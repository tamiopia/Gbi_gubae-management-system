import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHandler {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/gbigubae";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "6789";
    // Existing query
String selectQuery = "SELECT date, title FROM agendas WHERE department = ?";

// Updated query with id column
String updatedSelectQuery = "SELECT id, date, title FROM agendas WHERE department = ?";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void insertAgenda(String date, String department, String title, String content) {
        String insertSQL = "INSERT INTO agendas (submitted_date, department, title, content) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, date);
            preparedStatement.setString(2, department);
            preparedStatement.setString(3, title);
            preparedStatement.setString(4, content);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getAgendasByDepartment(String department) {
        String selectSQL = "SELECT date, title FROM agendas WHERE department = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, department);
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ResultSet getReportsByDate(String date) {
    String selectSQL = "SELECT department,title,content FROM agendas WHERE date = ?";
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

        preparedStatement.setString(1, date);
        return preparedStatement.executeQuery();

    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}


    // You can add more methods for retrieving content based on date and title
}
