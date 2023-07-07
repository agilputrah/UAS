package movierentalapp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserUseCase {
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                User user = new User(username, password);
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public void addUser(String username, String password) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)")) {

            statement.setString(1, username);
            statement.setString(2, password);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User added successfully.");
            } else {
                System.out.println("Failed to add user.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(String username, String newPassword) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE users SET password = ? WHERE username = ?")) {

            statement.setString(1, newPassword);
            statement.setString(2, username);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Password changed successfully.");
            } else {
                System.out.println("Failed to change password.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
