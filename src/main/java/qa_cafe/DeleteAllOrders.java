package qa_cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteAllOrders {
	static Connection conn;
	static Statement statement;
	static String myPass = Passcode.mySqlPassword;
	
	public static void proceed() {
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
		} catch (SQLException e) {
			System.out.println("Deletion failed.");
			e.printStackTrace();
		}
	}

}
