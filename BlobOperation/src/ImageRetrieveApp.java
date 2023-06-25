import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import in.ineuron.jdbcOp.JdbcOP;

public class ImageRetrieveApp {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sqlQuery = null;
		Scanner input = null;
		Integer id = null;
		try {

			connection = JdbcOP.getDbConnection();
			sqlQuery = "select id , pname , image from person where id = ? ";
			if (connection != null) {

				preparedStatement = connection.prepareStatement(sqlQuery);

				if (preparedStatement != null) {
					input = new Scanner(System.in);
					if (input != null) {
						System.out.println("Enter Id that Data you want to Retrieve : ");
						id = input.nextInt() ;
					}
					
					preparedStatement.setInt(1, id);
					resultSet = preparedStatement.executeQuery(); 
					
				}
				
				if(resultSet != null)
				{
					if(resultSet.next())
					{
						System.out.println("SID\tNAME\tIMAGE");
						int sid = resultSet.getInt(1);
						String name = resultSet.getString("pname");
						InputStream is = resultSet.getBinaryStream("image");
						
						File file = new File("cop.jpg");
						FileOutputStream fos = new FileOutputStream( file);
						
						//method 1 for reading and than writting 
						/*
						 * int i = is.read(); while(i != -1) { fos.write(i); i= is.read(); }
						 */
						

						//method 2 for reading and than writting 
						/*
						 * byte[] b = new byte[1024]; is.read(b);
						 * 
						 * fos.write(b);
						 */
						

						//method 3 for reading and than writting 
						IOUtils.copy(is, fos);
						
						fos.close();
						System.out.println(sid +"\t" +name+ "\t" +file.getAbsolutePath());
					
					}
					else {
						System.out.println("Data is not found bro....");
					}
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcOP.resourceCleanUp(connection, preparedStatement, null);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

}
