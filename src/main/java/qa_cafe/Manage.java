package qa_cafe;
import java.util.Scanner;

public class Manage {
	public static void main(String[] args) {
		boolean created = false;
		char option;
		Scanner userInput = new Scanner(System.in);

		while (true) {
			System.out.println("\n\n");
			System.out.println("Welcome to the QA Cafe Order Management System!\n");

			if (created == false) { // Opt C is made unavailable after it has been used
				System.out.println("C - Create database and table\n");
			}
			
			System.out.println("X - Add a customer\n");
			System.out.println("O - Check an order by ID (Read)\n");
			System.out.println("A - Check all orders (Read)\n");
			System.out.println("U - Update an order\n");
			System.out.println("D - Delete order by ID\n");
			System.out.println("T - Delete all orders\n");
			System.out.println("Q - Quit\n");

			option = userInput.nextLine().trim().toUpperCase().charAt(0);

			if (option == 'Q') {
				System.out.println("See you soon!");
				break;
			}

			if (option == 'C') {
				if (created)
					System.out.println("Database and table already created.");
				else {
					Create.proceed();
					created = true;
					
				}
				continue;
			}
			
			if (option == 'X') {
				AddCustomer.proceed();
				continue;
			}

			if (option == 'O') {
				ReadOrderByID.proceed();
				continue;
			}
			
			if (option == 'A') {
				ReadAllOrders.proceed();
				continue;
			}

			if (option == 'U') {
				Update.proceed();
				continue;
			}

			if (option == 'D') {
				DeleteOrderByID.proceed();
				continue;
			}
			
			if (option == 'T') {
				DeleteAllOrders.proceed();
				continue;
			}
		}
	
	}

}
