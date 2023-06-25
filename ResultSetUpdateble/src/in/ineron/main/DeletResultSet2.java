package in.ineron.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.attribute.PrintJobAttribute;

import in.ineuron.jdbcOp.JdbcOP;

public class DeletResultSet2{
	public static void main(String[] args)  {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		String sqlquery = null;
		try {
			connection = JdbcOP.getDbConnection() ;
			
			if (connection != null) {
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE);
			}
			sqlquery = "select id , name , age , address from sandeep.employee";
			if (statement != null) {
				resultSet =  statement.executeQuery(sqlquery);
			}
			if (resultSet != null) {
				System.out.println("Before Deletion details is.....");
				System.out.println("ID\tNAME\tAGE\tADDRESS\tSALARY");
				while(resultSet.next())
				{
					System.out.println(resultSet.getInt(1) +"\t"+ resultSet.getString(2) +"\t"+ resultSet.getInt(3) +"\t"+ resultSet.getString(4) );
				}
				
				System.in.read();
				
				resultSet.last();
				resultSet.deleteRow();
				
			
				resultSet.beforeFirst();
				System.out.println("after Updation details is.....");
				System.out.println("ID\tNAME\tAGE\tADDRESS\tSALARY");
				while(resultSet.next())
				{
					resultSet.refreshRow();
					System.out.println(resultSet.getInt(1) +"\t"+ resultSet.getString(2) +"\t"+ resultSet.getInt(3) +"\t"+ resultSet.getString(4) );
				}
			}
			
			
			
		}catch (SQLException  e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			 try {
				JdbcOP.resourceCleanUp(connection, null, resultSet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}