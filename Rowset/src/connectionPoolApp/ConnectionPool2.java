package connectionPoolApp;

import java.net.http.WebSocket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool2 {
public static void main(String[] args)throws Exception {
	
	RowSetFactory rsf =  RowSetProvider.newFactory();
	JdbcRowSet rs =  rsf.createJdbcRowSet();
	CachedRowSet crs =  rsf.createCachedRowSet();  
	WebRowSet wrs =  rsf.createWebRowSet();
	JoinRowSet jnrs =  rsf.createJoinRowSet();
	FilteredRowSet flrs =  rsf.createFilteredRowSet();
	
	System.out.println(rsf.getClass().getName());
	System.out.println(rs.getClass().getName());
	System.out.println(crs.getClass().getName());
	System.out.println(wrs.getClass().getName());
	System.out.println(jnrs.getClass().getName());
	System.out.println(flrs.getClass().getName());
   }
}