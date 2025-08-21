package ra.com.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnEcommerceDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce_db";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";
    public static Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, CallableStatement callSt) {
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (callSt!=null){
            try {
                callSt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
<<<<<<<< HEAD:Module3/RUM_ra_jv240711_MD3_SS1_JSP_Servlet/src/main/java/ra/com/util/ConnEcommerceDB.java



========
>>>>>>>> 35f1f755a0eaf38e9502085027813e4819a1d795:Module3/main/java/ra/com/util/ConnectionDB.java
            ;
        }
    }
}
