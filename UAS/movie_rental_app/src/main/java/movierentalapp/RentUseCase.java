package movierentalapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentUseCase {
    public void addNewRent(int movieId, String renter) {
        LocalDate rentDate = LocalDate.now();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO rents (rent_date, movie_id, renter) VALUES (?, ?, ?)")) {

            statement.setObject(1, rentDate);
            statement.setInt(2, movieId);
            statement.setString(3, renter);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Rent added successfully.");
            } else {
                System.out.println("Failed to add rent.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Rent> getActiveRentList() {
        List<Rent> rentList = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM rents WHERE return_date IS NULL")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                LocalDate rentDate = resultSet.getObject("rent_date", LocalDate.class);
                LocalDate returnDate = resultSet.getObject("return_date", LocalDate.class);
                int movieId = resultSet.getInt("movie_id");
                String renter = resultSet.getString("renter");

                Rent rent = new Rent(id, rentDate, returnDate, movieId, renter);
                rentList.add(rent);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rentList;
    }

    public void returnRent(int rentId) {
        LocalDate returnDate = LocalDate.now();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE rents SET return_date = ? WHERE id = ?")) {

            statement.setObject(1, returnDate);
            statement.setInt(2, rentId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Rent returned successfully.");
            } else {
                System.out.println("Failed to return rent.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
