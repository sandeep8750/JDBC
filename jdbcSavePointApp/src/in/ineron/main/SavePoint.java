package in.ineron.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;


import in.ineuron.jdbcOp.JdbcOP;

public class SavePoint {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
        Statement statement = null;
		Scanner input = new Scanner(System.in);
		ResultSet resultSet1 = null ;
		try {
		
			connection = JdbcOP.getDbConnection();
			if(connection != null)
			{
				statement = connection.createStatement();
				connection.setAutoCommit(false);
				
				if(statement != null)
				{
					statement.executeUpdate("insert into politicians (`name`,`party`) values('BJP','MODI')" );
					statement.executeUpdate("insert into politicians (`name`,`party`) values('cong','rahul')" );
					Savepoint sp = connection.setSavepoint();
					statement.executeUpdate("insert into politicians (`name`,`party`) values('app','arivind')" );
					
					connection.rollback(sp);
					connection.commit(); 
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JdbcOP.resourceCleanUp(connection, statement , resultSet1);
			System.out.println("Process done successfully....");
		}
			
   }
}

