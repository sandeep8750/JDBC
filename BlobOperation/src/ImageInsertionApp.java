import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.print.attribute.PrintJobAttribute;

import in.ineuron.jdbcOp.JdbcOP;

public class ImageInsertionApp {

	public static void main(String[] args)  {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlQuery = null ,  pname = null , imgLoc = null;
		Scanner input = null;
		try {
			
			connection = JdbcOP.getDbConnection();
			sqlQuery = "insert into person(`pname`,`Image`) value(?,?)";
			if(connection != null) {
				
				preparedStatement = connection.prepareStatement(sqlQuery);
				
				if(preparedStatement != null) {
					input = new Scanner(System.in);
					if(input != null )
					{
						System.out.println("Enter person name ::");
						pname = input.next();
						System.out.println("Enter image location :: ");
						imgLoc  = input.next();
						
					}					
					
					preparedStatement.setString(1,pname );
					preparedStatement.setBinaryStream(2, new FileInputStream(new File(imgLoc)));
					int rowAffected = preparedStatement.executeUpdate();
					System.out.println("Number of row is affected : " + rowAffected);
				}
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
