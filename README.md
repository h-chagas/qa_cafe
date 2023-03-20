## This is a Java JDBC project created by Hugo Cidral das Chagas

### Initial instructions:

#### -- Store your mySQL password in a safe mode -- <br>
1 - Create a .gitignore file, writing the following file to be ignored by Git: Passcode.java; <br>
2 - Create a stardard class (do not mark the public static void main method) and name it as Passcode.java;  <br>
3 - Open the file/class above, create a public static String variable named as mySqlPassword and asign your mySQL password in it; <br>
4 - The getConnection() method already has the myPass variable passed as parameter. Therefore, your connection with your mySQL workbench will be done in a safe mode. <br><br>

#### -- How to operate the QA Cafe Order management System -- <br>
5. Clone/fork the "qa_cafe" project to your machine;<br>
6. Open the qa_cafe project using your prefered IDE (I suggest Eclipse);<br>
7. Navigate throughtout the project to open the Manage.java file, where is the main method with this Java application: src/main/java/qa_cafe/Manage.java;<br>
8. Run the file;<br>

#### -- Create a database and table --<br>
9. First thing first: If you don't have MySQL installed, installed so. Installing MySQL Workbench will also make the operation easier. Once you have your MySQL setup, complete the steps 3 and 4; <br>
10. Run the Manage.java file again. A menu will be shown in the IDE console area, with a greeting message and some options: <br><br>
![Show the system's main menu](https://i.ibb.co/1QjDKz0/Screenshot-2023-03-16-at-14-38-11.png)
<br>
11. The first thing to do is **create a DB and a table**. So type **C** in the console and press enter. If it works, a confirmation message will be shown; <br>

#### -- Add a customer --<br>
12. Choose the option 'Add a customer' typing **X** in the console; <br>
13. Follow the instructions in order to add the customer order to the table; <br>
* Enter order ID:   __accepts only numbers__  (PRIMARY KEY) <br>
* Customer name:   __max. 100 characters__  <br>
* Beverage:   __max. 50 characters__  <br>
* Size:   __max. 1 character__ **L for large - M for medium - S for small**  <br>
* Extras: (e.g. cream on the top)  __max. 50 characters__  <br>
* Price: __only integers__  <br>
If the form was filled properly, a confirmation message will be shown; <br>

#### -- Read a customer order by ID --<br>
14. Choose the option 'Check an order by ID' typing **O** in the console; <br>
15. Type the order ID to see it;
The chosen order will be shown in the console;

#### -- Read all customer orders --<br>
16. Choose the option 'Check all orders' typing **A** in the console; <br>
All orders will be shown in the console;

#### -- Update a customer order --<br>
17. Choose the option 'Update an order' typing **U** in the console; <br>
18. Follow the instructions in order to update the customer order to the table; <br>
* Enter the order ID to be updated: <br>
* Update the drink  <br>
* Update the drink size  <br>
* Update the extras  <br>
* Update the price  <br>
If the form was filled properly, a confirmation message will be shown followed by the chosen order updated; <br>

#### -- Delete a customer orders by ID --<br>
19. Choose the option 'Delete order by ID' typing **D** in the console; <br>
20. Type the order ID to delete it;
If it worked, a confirmation message will be shown; <br>

#### -- Delete all customer orders --<br>
21. Choose the option 'Delete all orders' typing **T** in the console; <br>
If it worked, a confirmation message will be shown; <br>

#### -- To quit --<br>
22. Choose the option 'Delete all orders' typing **T** in the console; <br>
If it worked, a "See you soon!" message will be shown; <br>


### Tests - JUnit:
To develop the tests, I used JUnit which is the most popular Java unit testing framework.

#### -- To perform the tests --<br>
1. The tests were created in the QACafe_test.java file;
2. As a connection, a schema and a table must be created first, the testTableIsCreated() should be run for first. If a table had been created throughtout the standard method, Create.java class, this test will fail for a obvious reason. Once this test was run once, please comment it out.
3. All the other tests are commented out. My suggestion is to uncomment each test to run one by one.



Future aditional features:
- [ ] Autoincrement for order ID's;
- [ ] Float number to price column;
- [ ] Create a GUI for the project;
- [ ] Add more columns for the orders table, such as to_eat column;
- [ ] Add more tables, such as employees table;
