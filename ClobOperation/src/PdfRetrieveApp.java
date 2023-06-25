import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import in.ineuron.jdbcOp.JdbcOP;

public class PdfRetrieveApp {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sqlQuery = null;
		Scanner input = null;
		Integer id = null;
		try {

			connection = JdbcOP.getDbConnection();
			sqlQuery = "select id , name , history from cities where id = ? ";
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
						System.out.println("SID\tNAME\tPdf");
						int sid = resultSet.getInt(1);
						String name = resultSet.getString(2);
						Reader fR = resultSet.getCharacterStream(3);
						
						File file = new File("history.pdf");
						FileWriter fw = new FileWriter(file);
						
						
						IOUtils.copy(fR, fw);
						
						fw.close();
						System.out.println(sid +"\t" +name+ "\t" +file.getAbsoluteFile());
					
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
