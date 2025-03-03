import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Refactorization {

    public static final String URL = "jdbc:mysql://localhost:3306/dictionary";
    public static final String USER = "root";
    public static final String PASSWORD = "santiish";

    private void getData(String tableName, String columnName) {

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName)
        )
        {
            while (resultSet.next()) {
                System.out.println(columnName + ": " + resultSet.getString(columnName));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.toString());
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Refactorization example = new Refactorization();
        example.getData("words", "Spanish");
        example.getData("people", "Email");
    }
}
