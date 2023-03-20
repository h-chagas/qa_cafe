package qa_cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteAllOrders {
	static Connection conn;
	static Statement statement;
	static String myPass = Passcode.mySqlPassword;
	
	public static boolean proceed(boolean deleteAllWorked) {
		boolean deleteAllOrders = false;
		deleteAllWorked = false;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa_cafe_db", "root", myPass);
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}

		try {
			statement.executeUpdate("DELETE FROM orders");
			System.out.println("All data successfully deleted");
			deleteAllWorked = true;
		} catch (SQLException e) {
			System.out.println("Deletion failed.");
			e.printStackTrace();
		}
		
		if (deleteAllWorked) {
			deleteAllOrders = true;
		}
		return deleteAllOrders;
	}

}
