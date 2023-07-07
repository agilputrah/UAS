package movierentalapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieUseCase {
    public List<Movie> getMovieList() {
        List<Movie> movieList = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM movies")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");

                Movie movie = new Movie(id, title, genre);
                movieList.add(movie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movieList;
    }

    public void addMovie(String title, String genre) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO movies (title, genre) VALUES (?, ?)")) {

            statement.setString(1, title);
            statement.setString(2, genre);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Movie added successfully.");
            } else {
                System.out.println("Failed to add movie.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMovie(int movieId) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM movies WHERE id = ?")) {

            statement.setInt(1, movieId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Movie deleted successfully.");
            } else {
                System.out.println("Failed to delete movie.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
