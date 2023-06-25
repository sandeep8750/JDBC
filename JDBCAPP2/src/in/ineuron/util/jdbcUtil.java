package in.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcUtil {	
	

	public static Connection getJdbcConnection() throws SQLException, IOException{
		
		FileInputStream fis = new FileInputStream("src\\in\\ineuron\\properties\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		//2. Connection Established 
		Connection connection  = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
		return connection;
		
	}
	
	//6.Close Resource and cleanup code 
	public static  void  cleanUp(Connection conn, Statement  statement , ResultSet resultSet) throws SQLException{

		if(conn!=null)
		{
			conn.close(); 
		}
		if(statement!=null)
		{
			statement.close();
		}
		if(resultSet!=null)
		{
			resultSet.close();
		}
		
	}
	
	

}
