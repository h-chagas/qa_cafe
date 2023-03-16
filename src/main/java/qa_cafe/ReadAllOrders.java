package qa_cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadAllOrders {
	
	static Connection conn;
	static Statement statement;
	static String myPass = Passcode.mySqlPassword;
	
	public static void proceed() {
		String query = "SELECT * FROM qa_cafe_db.orders\r\n";
		ResultSet rs;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa_cafe_db", "root", myPass);
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}

		try {
			rs = statement.executeQuery(query);
			System.out.println("Check all orders:\n");
			while (rs.next()) {
				System.out.println("order_id: " + rs.getInt("order_id")
						+ "\tcustomer_name: " + rs.getString("customer_name")
						+ "\tdrink: " + rs.getString("drink")
						+ "\tsize: " + rs.getString("size")
						+ "\textras: " + rs.getString("extras")
						+ "\tprice: " + rs.getInt("price"));
			}
		} catch (SQLException e) {
			System.out.println("Bad query.");
			e.printStackTrace();
		}
	}

}
