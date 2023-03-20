package qa_cafe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
	static Connection conn;
	static Statement statement;
	static String myPass = Passcode.mySqlPassword;
	
	public static int getInt(String prompt) {
		System.out.println(prompt);
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
		
	public static String getString(String prompt) {
		System.out.println(prompt);
		Scanner s = new Scanner(System.in);
		return s.nextLine();
	}
	
	public static boolean proceed(boolean updatedWorked) {
		
		String drink;
		String size;
		String extras;
		float price;
		int order_id;
		
		boolean updateOrder = false;
		updatedWorked = false;
						
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa_cafe_db", "root", myPass);
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
		
		
		order_id = getInt("Enter the order ID to be updated: \n");
		drink = getString("Update the drink: \n");
		size = getString("Update the size: \n");
		extras = getString("Update the extras: \n");
		price = getInt("Update the price: \n");
					
		String query = "SELECT * FROM orders WHERE order_id=" + order_id + "\r\n";
		ResultSet rs;
		
		try {
			statement.executeUpdate("UPDATE orders SET drink='" + drink + "',  size= '"+ size + "', extras= '" + extras + "', price= '" + price + "' WHERE order_id = " + order_id + ";");
			System.out.println("Order successfully updated. The order " + order_id + " is now:");
			updatedWorked = true;
			
			rs = statement.executeQuery(query);
			while (rs.next()) {
				System.out.println("order_id: " + rs.getInt("order_id")
						+ "\tcustomer_name: " + rs.getString("customer_name")
						+ "\tdrink: " + rs.getString("drink")
						+ "\tsize: " + rs.getString("size")
						+ "\textras: " + rs.getString("extras")
						+ "\tprice: " + rs.getInt("price"));
			}
		} catch (SQLException e) {
			System.out.println("Insertion failed.");
			e.printStackTrace();
		}
		
		if (updatedWorked == true) {
			updateOrder = true;
		}
		return updateOrder;
		
	}
}
