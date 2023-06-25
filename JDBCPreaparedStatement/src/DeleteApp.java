
import java.security.DrbgParameters.Reseed;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UnknownFormatConversionException;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.mysql.cj.ServerPreparedQueryTestcaseGenerator;

import in.ineuron.util.jdbcUtil;

//JDBC4.X autoloading feature is enabled.
public class DeleteApp {

	public static void main(String[] args) {
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		Scanner input = null;
		ResultSet resultSet = null;
		Integer sid = null;
		String sgender = null;
		Integer   rowAffected = null;
		try {
			
		   input = new Scanner(System.in);
//			//step 1. load Driver
//			Driver loading done by complier if you don't done 
//			but here we are doning this things inside jdbcUtil clas inside getjdbcConnection 
			
			// Step2. Establish the Connection
			 connection = jdbcUtil.getJdbcConnection();
			 System.out.println("Connection is Established....");
				
				// Step3. Create statement Object and send the Query
			
			 System.out.println("sid" + "\t\t" + "Name" + "\t\t" + "Age" + "\t\t" + "Address" + "\t\t" + "Gender");
			 System.out.println("========================================================================");
			 

			 String sqlSeletionQuery = "delete from student_info where sid=? ";
			 if(connection != null)
			 {  
				 preparedStatement  = connection.prepareStatement(sqlSeletionQuery);
			 }
			 
			 if(preparedStatement != null)
			 {
				 System.out.println("Enter that student id that you want to delete  :: ");
                  sid = input.nextInt();
                  
                  
                  preparedStatement.setInt(1, sid);
				 
				 rowAffected = preparedStatement.executeUpdate();
			 }
			 System.out.println("Number of Rows is Affected :: " + rowAffected);
//			 if(resultSet != null) {
//				
//				 try {
//					if(resultSet.next())
//					{
//						System.out.println(resultSet.getString(1));
//					}
//					else {
//						System.out.println("Result not found in database....");
//					}
//				} catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}
//			 }
//			if(connection != null)
//			{
//				preparedStatement = connection.prepareStatement(sqlSeletionQuery);
//			}
//			
//			if(preparedStatement != null) {
//			  resultSet = preparedStatement.executeQuery();
//			  
//			  while(resultSet.next()) {
//				 System.out.println(resultSet.getInt(1) +"\t\t"+ resultSet.getString(2) +"\t\t"+ resultSet.getInt(3) +"\t\t"+ resultSet.getString(4) +"\t\t"+ resultSet.getString(5));
//				  
//			  }
//			}
			

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
