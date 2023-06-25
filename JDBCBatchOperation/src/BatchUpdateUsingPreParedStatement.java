import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.print.attribute.PrintJobAttribute;

import in.ineuron.jdbcOp.JdbcOP;

public class BatchUpdateUsingPreParedStatement {

	public static void main(String[] args)  {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlquery = null , name = null , address = null ;
		Integer age = null;
		Scanner input  = new Scanner(System.in);
		try {
			
			sqlquery = "insert into sandeep.employee (name , age , address ) value (?,?,?)";
			connection = JdbcOP.getDbConnection();
			
			if (connection != null) {	
			preparedStatement =	connection.prepareStatement(sqlquery);
						
			}
			if (preparedStatement != null) {
				
				while(true) {
					
					
						System.out.println("Enter name of Employee :: ");
						name  = input.next();
						System.out.println("Enter age of Employee :: ");
					    age   = input.nextInt();
					    System.out.println("Enter address of Employee ::");
					    address = input.next();
					
					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, age);
					preparedStatement.setString(3, address);
					
					//make batch to execute at once all query reduce traffic 
					//all query go and sit inside batch & it will send to DB at once 
					// by shoting this command given below 
					preparedStatement.addBatch(); 
					
					
					System.out.println("Do you want to insert one more record [Yes/No]:: ");
					String option  =  input.next();

					System.out.println("\n");
					System.out.println("\n");
					System.out.println("\n");
					
					if(option.equalsIgnoreCase("no"))
					{
						break;
					}
					
				}
					
				preparedStatement.executeBatch();
				
				System.out.println("all Data of Empolyee inserted successfully sir ......");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {
				JdbcOP.resourceCleanUp(connection, preparedStatement, null);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
	}

}
