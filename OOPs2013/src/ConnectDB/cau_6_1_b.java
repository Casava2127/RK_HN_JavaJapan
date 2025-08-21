package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class cau_6_1_b {
    public static void main(String[] args) {
        // Connect DB
    	String databaseUrl = "jdbc:mysql://127.0.0.1:3306/qlsv";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(databaseUrl, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Table1");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Id") + " " +
                                   resultSet.getString("Name") + " " +
                                   resultSet.getString("Address") + " " +
                                   resultSet.getDouble("Total"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

