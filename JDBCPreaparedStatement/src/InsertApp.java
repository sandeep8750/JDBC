
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UnknownFormatConversionException;

import com.mysql.cj.ServerPreparedQueryTestcaseGenerator;

import in.ineuron.util.jdbcUtil;

//JDBC4.X autoloading feature is enabled.
public class InsertApp {

	public static void main(String[] args) {
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		Scanner input = null;
		
		try {
			
		   input = new Scanner(System.in);
//			//step 1. load Driver
//			Driver loading done by complier if you don't done 
//			but here we are doning this things inside jdbcUtil clas inside getjdbcConnection 
			
			// Step2. Establish the Connection
			 connection = jdbcUtil.getJdbcConnection();	
				System.out.println("Connection is Established....");
				
				// Step3. Create statement Object and send the Query
			String sqlInsertQuery = "insert into student_info(`sname`,`sage`,`saddress`,`sgender`) values(?,?,?,?)";
			if(connection != null) {
				preparedStatement = connection.prepareStatement(sqlInsertQuery);		
			}
			
			if(preparedStatement != null)
			{
				
				//taking input from user 
				System.out.println("Enter Data into DataBase :: ");
				System.out.println();
				
				System.out.println("Enter Name of Student :: ");
				String name = input.next();
				
				System.out.println("Enter Student Age :: ");
				int age = input.nextInt();
				
				System.out.println("Enter Student Address :: ");
				String address = input.next();
				
				System.out.println("Enter Student Gender :: ");
				String gender = input.next();
				
				
				//use precompiled query to set value 
			preparedStatement.setString(1,name);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(3, address);
			preparedStatement.setString( 4,gender);
			
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("Number of is Affected is ::" + rowCount) ;
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				jdbcUtil.cleanUp(connection, preparedStatement, null);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	
	}
}
