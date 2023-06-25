import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UnknownFormatConversionException;

//JDBC4.X autoloading feature is enabled.
public class InsertApp {

	public static void main(String[] args) throws SQLException, ClassNotFoundException , UnknownFormatConversionException {

		Scanner input = new Scanner(System.in);
		
		//step 1. load Driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step2. Establish the Connection
		String url = "jdbc:mysql://localhost:3306/student";
		String user = "root";
		String password = "sandeep@8750";
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println("connection object created...");

		// Step3. Create statement Object and send the Query
		Statement statement = connection.createStatement();
		System.out.println("statement object created...");

		//Taking input from user 
		
		System.out.println("Enter Data into DataBase : ");
		System.out.println();
		System.out.println("Enter Name of Student : ");
		String name = input.next();
		System.out.println("Enter Student Ager : ");
		int age = input.nextInt();
		System.out.println("Enter Student Address : ");
		String address = input.next();
		System.out.println("Enter Student Gender : ");
		String gender = input.next();
		// Step4. Execute the Query and Process the resultSet
		String sqlInsertQuery = String.format("insert into student_info (`sname`,`sage`,`saddress`,`sgender`) values('%s',%d,'%s','%s')",name,age,address,gender);
		int rowAffected = statement.executeUpdate(sqlInsertQuery);
		System.out.println("No of rows affected is :: " + rowAffected);

		// Step6. Close the resources
		statement.close();
		connection.close();
		System.out.println("closing the resources...");

	}
}
