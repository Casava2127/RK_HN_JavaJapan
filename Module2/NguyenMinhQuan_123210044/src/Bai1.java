import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Bai1 {
	public static void main(String[] args) {
		System.out.println("Ket noi CSDL");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/data";
			Connection con = DriverManager.getConnection(url,"root","123456");
			Statement stmt = con.createStatement();
			
			String sql = "SELECT * FROM table1";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String address = rs.getString("Address");
				double total =rs.getDouble("Total");

				System.out.println("ID = "+ id + " Name = " + name + " Address = " + address + " Total = " + total);
				System.out.println("\n");
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {System.out.println("Error " + e);}
 	
}
	}
