package in.ineron.main;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.ineuron.jdbcOp.JdbcOP;

public class DateInsertionApp {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Scanner input = null;
		String name = null;
		String dob = null;
		String dom = null;
		java.sql.Date sqldob = null;
		java.sql.Date sqldom = null;
 		
		try {
			connection = JdbcOP.getDbConnection();
		
			String sqlQuery = "insert into student.users (`name` , `dob` , `dom` ) values(?,?,?); ";
			if(connection != null)
			{
				preparedStatement=  connection.prepareStatement(sqlQuery);				
			}
			if(preparedStatement != null)
			{
				input = new Scanner(System.in);
				if(input != null)
				{
					System.out.println("Enter the username :: ");
					name = input.next();
					System.out.println("Enter the DOB (MM-dd-yyyy) :: ");
					dob = input.next();
					System.out.println("Enter the DOM (yyyy-MM-dd) :: ");
					dom = input.next();	
							
				}
				
				if(dob != null)
				{
					SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
				    java.util.Date uDate = sdf.parse(dob);
				    
				    long l = uDate.getTime();
				     sqldob = new java.sql.Date(l);
				    
				}
				if(dom != null) {					
					 sqldom = java.sql.Date.valueOf(dom);
				}
				
			    //set the input values to Query and executeupdate method 
				preparedStatement.setString(1, name);
				preparedStatement.setDate(2, sqldob);
				preparedStatement.setDate( 3, sqldom);
				
				System.out.println("Number of Affected is :: " + preparedStatement.executeUpdate());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			JdbcOP.resourceCleanUp(connection, preparedStatement, null);
		}
	}

}
