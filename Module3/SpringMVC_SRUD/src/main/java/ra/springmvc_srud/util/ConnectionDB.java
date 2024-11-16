package ra.springmvc_srud.util;

public class ConnectionDB {
    public static Connection getConnection() {
        // Implement your own connection logic here
        // Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot load MySQL JDBC driver", e);
        }

        // Establish the connection to the database
        String url = "jdbc:mysql://localhost:3306/spring_crud_db";
        String username = "root";
        String password = "your_password_here";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database", e);
        }
        // For example, you can use JDBC to connect to your database
        return null;
    }
}
