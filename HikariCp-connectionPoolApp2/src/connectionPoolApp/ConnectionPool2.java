package connectionPoolApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool2 {
public static void main(String[] args)throws Exception {
		
	String  sqlQuery = "select * from employee";
	String config = "src\\connectionPoolApp\\db.properties";
	HikariConfig hikariConfig =  new HikariConfig(config);
	
	
	
	try(HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig)){
		Connection connection = hikariDataSource.getConnection();
		Statement statement =  connection.createStatement();
	    ResultSet resultSet  = statement.executeQuery(sqlQuery);
		
	    System.out.println("Id\tname\tage\taddress");
	    if (resultSet != null) {
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) +"\t"+ resultSet.getString(2)+"\t"+ resultSet.getInt(3) +"\t"+ resultSet.getString(4));				
			}
				
		}
	}
	
}
}
