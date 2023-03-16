package qa_cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOrderByID {
	static Connection conn;
	static Statement statement;
	static String myPass = Passcode.mySqlPassword;
	
	public static int getInt(String prompt) {
		System.out.println(prompt);
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
	
	public static void proceed() {
		int order_id = getInt("Choose the order ID to be deleted: ");
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa_cafe_db", "root", myPass);
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}

		try {
			statement.executeUpdate("DELETE FROM orders WHERE order_id=" + order_id + ";");
			System.out.println("Data successfully deleted");
		} catch (SQLException e) {
			System.out.println("Deletion failed.");
			e.printStackTrace();
		}
	}
}
