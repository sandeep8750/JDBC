package connectionPoolApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSet {

	public static void main(String[] args) throws Exception {
		
		Connection connection =  DriverManager.getConnection("jdbc:mysql:///sandeep", "root", "sandeep@8750");
		Statement statement =  connection.createStatement();
		ResultSet resultSet =  statement.executeQuery("select * from employee");
		
		RowSetFactory  rsf =  RowSetProvider.newFactory();
		javax.sql.rowset.CachedRowSet crs =  rsf.createCachedRowSet();
		// it copy reference of resutlset int crs because crs is disconnected rowset so we can perfrom operation after 
		//connection close() from database ;
		connection.close();

		while(crs.next())
		{
			System.out.println(crs.getInt(1) +"\t"+ crs.getString(2) +"\t"+ crs.getInt(3) +"\t"+ crs.getString(4) );
		}
	}
}
