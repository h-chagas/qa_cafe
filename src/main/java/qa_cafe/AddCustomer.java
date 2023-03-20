package qa_cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddCustomer {
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
	
	
	public static boolean proceed(boolean addCustomerWorked) {
		String data;
		int order_id;
		String customer_name;
		String drink;
		String size;
		String extra;
		float price;
		
		boolean addACustomer = false;
		addCustomerWorked = false;
		
		
		try {//Access the MySQL
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", myPass);
			statement = conn.createStatement();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		try {//Establish connection with DB
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa_cafe_db", "root", myPass);
			statement = conn.createStatement();

		} catch (SQLException e) {
			System.out.println("Connection with DB failed.");
			e.printStackTrace();
		}
		
		System.out.println("Add the next customer \n");
		order_id = getInt("Enter order ID: \n");
		customer_name = getString("Customer name: \n");
		drink = getString("Beverage: \n");
		size = getString("What size? L, M or S: \n");
		extra = getString("Any extra: \n");
		price = getInt("Please, enter the price:");
		
		
		try {
			data = "INSERT INTO orders VALUES ('" + 
			order_id + "', '" +
			customer_name + "', '" + 
			drink + "', '" + 
			size + "', '" +
			extra + "', '" +
			price + "')";
			statement.executeUpdate(data);
			System.out.println("Order successfully added!");
			addACustomer = true;
			
		} catch (SQLException e) {
			System.out.println("Insertion failed.");
			e.printStackTrace();
		}
		
		if (addACustomer == true) {
			addCustomerWorked = true;
		} 
		return addCustomerWorked;
			
		
		
	}
}
