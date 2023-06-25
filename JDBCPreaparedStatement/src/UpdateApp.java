
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Scanner;

import in.ineuron.util.jdbcUtil;

//JDBC4.X autoloading feature is enabled.
public class UpdateApp {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Scanner input = null;
		ResultSet resultSet = null;
		Integer sid = null;
		String sgender = null;
		Integer rowAffected = null;
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

			String sqlSeletionQuery = "update student_info set sgender=? where sid=? ";
			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlSeletionQuery);
			}

			if (preparedStatement != null) {
				System.out.println("Enter that student id whose Gender you want to modify :: ");
				sid = input.nextInt();

				System.out.println("Enter that student id whose Gender you want to modify :: ");
				sgender = input.next();

				preparedStatement.setString(1, sgender);
				preparedStatement.setInt(2, sid);

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
