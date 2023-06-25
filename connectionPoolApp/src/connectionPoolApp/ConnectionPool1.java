package connectionPoolApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class ConnectionPool1 {
public static void main(String[] args) {
	Statement statement = null;
	String sqlQuery = null;
	ResultSet resultSet = null;
	try {
		MysqlConnectionPoolDataSource datasource = new MysqlConnectionPoolDataSource();
		datasource.setURL("jdbc:mysql://localhost:3306/sandeep");
		datasource.setUser("root");
		datasource.setPassword("sandeep@8750");
		
		
		Connection connection =  datasource.getConnection();
		sqlQuery = "select * from employee";
		if(connection != null)
		{
		statement =  connection.createStatement();	
		resultSet =  statement.executeQuery(sqlQuery);
		}
		if (resultSet != null) {
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t" + resultSet.getString(4) );
			}
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}
}
