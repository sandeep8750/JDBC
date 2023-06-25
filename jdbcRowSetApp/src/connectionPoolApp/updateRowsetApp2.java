package connectionPoolApp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class updateRowsetApp2 {
public static void main(String[] args) throws SQLException, IOException {
		RowSetFactory rsf	= RowSetProvider.newFactory();
	   JdbcRowSet jrs = rsf.createJdbcRowSet();
	   
	   jrs.setUrl("jdbc:mysql:///sandeep");
	   jrs.setUsername("root");
	   jrs.setPassword("sandeep@8750");
	   
	   jrs.setCommand("select * from employee");
	   jrs.execute();
	   
	   while(jrs.next())
	   {
		   int actualAge = jrs.getInt(3);
		   
		   if(actualAge > 25)
		   {
			   int updatedAge = actualAge + 10 ;
			   jrs.updateInt(3, updatedAge);
			   jrs.updateRow();
		   }
	   }
	   System.out.println("Record updated successfully......");
	   jrs.close();
	}
}