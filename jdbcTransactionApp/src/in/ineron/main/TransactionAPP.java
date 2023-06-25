package in.ineron.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


import in.ineuron.jdbcOp.JdbcOP;

public class TransactionAPP {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
        Statement statement = null;
		Scanner input = new Scanner(System.in);
		ResultSet resultSet1 = null , resultSet2 = null;
		try {
		
			connection = JdbcOP.getDbConnection();
			if (connection != null) {
				statement = connection.createStatement();
				
				//Before Transaction Begins....
				System.out.println("Before Transaction Balance is ...");
				if (statement != null) {
					System.out.println("Name \t Balance");
					resultSet1 = statement.executeQuery("select name ,balance from account");
					if (resultSet1 != null) {
						while(resultSet1.next())
						{
							System.out.println(resultSet1.getString(1) + "\t" + resultSet1.getInt(2));
						}
					}
				}
				
				System.out.println("\n Transaction Begins....");
				connection.setAutoCommit(false);
				
				statement.executeUpdate("update account set Balance  = Balance+2000 where name = 'Sandeep'");
				statement.executeUpdate("update account set Balance  = Balance+2000 where name = 'Shivam'");
				
				System.out.println("Can you confirm the transaction of 2000INR... [YES/NO]");
				String option = input.next();
				if(option.equalsIgnoreCase("Yes"))
				{
					connection.commit();
				}
				else {
					connection.rollback();
				}
			}
			
			System.out.println("After Transaction Balance is....");
			
			resultSet2 =  statement.executeQuery("select name , balance from account ");
			System.out.println("Name \t Balance");
			if (resultSet2 != null) {
				while(resultSet2.next())
				{
					System.out.println(resultSet2.getString(1) + "\t" + resultSet2.getInt(2));
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

