package qa_cafe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
	static Connection conn;
	static Statement statement;
	static String myPass = Passcode.mySqlPassword;
	
	public static boolean proceed(boolean allGood) {
		String newDB;
		String newTable;
		
		boolean haveAccess = false;
		boolean createDB = false;
		boolean estabConnection = false;
		boolean createTable = false;
		allGood = false;
		
		try {//Access the MySQL
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", myPass);
			statement = conn.createStatement();
			haveAccess = true;
		} catch(SQLException e) {
			System.out.println("Connection 1 failed.");
			e.printStackTrace();
		}
		newDB = "CREATE DATABASE qa_cafe_db;";
		
			
		try {//Create the DB
			statement.executeUpdate(newDB);
			System.out.println("\nDatabase created!");
			createDB = true;
		} catch (SQLException e) {
			System.out.println("Database creation failed.");
			e.printStackTrace();
		}
		
				
		try {//Establish connection with DB
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa_cafe_db", "root", myPass);
			statement = conn.createStatement();
			estabConnection = true;
		} catch (SQLException e) {
			System.out.println("Connection with DB failed.");
			e.printStackTrace();
		}
		
		
		newTable = "CREATE TABLE orders " +
				"(order_id INT NOT NULL AUTO_INCREMENT, " +
				" customer_name VARCHAR(100), " +
				" drink VARCHAR(50), " +
				" size VARCHAR(1), " +
				" extras VARCHAR(50), " +
				" price DECIMAL(10,2), " +
				" PRIMARY KEY (order_id));";
				
		
		try {//Create the table
			statement.executeUpdate(newTable);
			System.out.println("Table created!");
			createTable = true;
		} catch (SQLException e) {
			System.out.println("Table creation failed.");
			e.printStackTrace();
		}
		
		if (haveAccess == true && createDB == true && estabConnection == true && createTable == true)
			allGood = true;
			return allGood;
		
			
	}

}
