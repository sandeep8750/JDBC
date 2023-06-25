package in.ineuron.jdbcOp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcOP {
	
	public static Connection getDbConnection() throws SQLException, IOException {
		
		FileInputStream fis = new FileInputStream("D:\\Java\\JDBC\\BlobOperation\\src\\properties\\DBcardintial.properties");
		Properties getCardintialFormproProperties = new Properties();
		
		getCardintialFormproProperties.load(fis);
		
		String url = getCardintialFormproProperties.getProperty("url");
		String username = getCardintialFormproProperties.getProperty("username");
		String password = getCardintialFormproProperties.getProperty("password");
		
		Connection connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}

	
	public static void resourceCleanUp(Connection connection , PreparedStatement preparedStatement , ResultSet resultSet) throws SQLException {
		
		if(connection != null)
		{
			connection.close();
		}
		if(preparedStatement!= null)
		{
			preparedStatement.close();
		}
		if(resultSet != null)
		{
			resultSet.close();
		}
	}
}


