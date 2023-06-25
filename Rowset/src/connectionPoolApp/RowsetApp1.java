package connectionPoolApp;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowsetApp1 {
public static void main(String[] args) throws SQLException, IOException {
	
	RowSetFactory rsf =  RowSetProvider.newFactory();
	
	JdbcRowSet jrs =  rsf.createJdbcRowSet();
	
	jrs.setUrl("jdbc:mysql:///sandeep");
	jrs.setUsername("root");
	jrs.setPassword("sandeep@8750");
	
	jrs.setCommand("select *from employee");
	jrs.execute();
	
	if(jrs != null)
	{
		while(jrs.next())
		{
			System.out.println(jrs.getInt(1) +"\t"+ jrs.getString(2) +"\t"+ jrs.getInt(3) +"\t"+ jrs.getString(4));
		}
		
		System.out.println("retrieve record in backword direction....");
		while(jrs.previous())
		{
			System.out.println(jrs.getInt(1) +"\t"+ jrs.getString(2) +"\t"+ jrs.getInt(3) +"\t"+ jrs.getString(4));
		}
		
		jrs.first();
		jrs.absolute(4);
		System.out.println("retrieve record in absolute direction....");
		while(jrs.next())
		{
			System.out.println(jrs.getInt(1) +"\t"+ jrs.getString(2) +"\t"+ jrs.getInt(3) +"\t"+ jrs.getString(4));
		}
		
		jrs.first();
		jrs.relative(-1);
		System.out.println("retrieve record in absolute direction....");
		while(jrs.next())
		{
			System.out.println(jrs.getInt(1) +"\t"+ jrs.getString(2) +"\t"+ jrs.getInt(3) +"\t"+ jrs.getString(4));
		}
		
		
		
		
	}
}
}
