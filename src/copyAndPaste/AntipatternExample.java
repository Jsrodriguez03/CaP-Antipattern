package copyAndPaste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AntipatternExample {

  public static final String URL = "jdbc:mysql://localhost:3306/dictionary";
  public static final String USER = "luis";
  public static final String PASSWORD = "Shayra11";

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
    AntipatternExample example = new AntipatternExample();
    example.getData("words", "kankuamo");
    example.getData("people", "email");
  }
}
