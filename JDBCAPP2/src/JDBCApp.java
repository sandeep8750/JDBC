import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.ineuron.util.jdbcUtil;

public class JDBCApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement   = null;
		ResultSet resultSet   = null;
		try {
			
			connection = jdbc.getJdbcConnection();

		    statement  = connection.createStatement();
		    
		    resultSet  = statement.executeQuery("select * from student_info");
		    
		    System.out.println("SID\t\tSNAME\t\tSAGE\t\tSADDRESS\t\tSGENDER");
			
		    while(resultSet.next())
		    {
		    	System.out.printf("%-15d %-15s %-15d %-15s %15s",resultSet.getInt(1) , resultSet.getString(2), resultSet.getInt(3),  resultSet.getString(4) ,resultSet.getString(5));
		    System.out.println();
		    }
		}catch(IOException e) {
			e.printStackTrace();
		}
		catch(SQLException se){
			se.printStackTrace();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				jdbcUtil.cleanUp(connection, statement, resultSet);
				System.out.println("All set well");
			} catch (SQLException se ) {
				// TODO: handle exception
				se.printStackTrace();
			}
			
		}
	}

}
