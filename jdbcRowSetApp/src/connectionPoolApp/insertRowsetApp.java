package connectionPoolApp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class insertRowsetApp {
public static void main(String[] args) throws SQLException, IOException {
	
	RowSetFactory rsf = RowSetProvider.newFactory();
	JdbcRowSet jrs =  rsf.createJdbcRowSet();
	
	jrs.setUrl("jdbc:mysql:///sandeep");
	jrs.setUsername("root");
	jrs.setPassword("sandeep@8750");
	
	jrs.setCommand("select * from employee");
	jrs.execute();
	
	Scanner input = new Scanner(System.in);
	
	jrs.moveToInsertRow();
	while(true) {
		System.out.println("Enter employee name :: ");
		String name = input.next();
		
		System.out.println("Enter employee age :: ");
		int age = input.nextInt();
		
		System.out.println("Enter employee address :: ");
		String address = input.next();
		
		jrs.updateString(2, name);
		jrs.updateInt(3, age);
		jrs.updateString(4, address);
		
		jrs.insertRow();
		System.out.println("Record inserted successfully......");
		
		System.out.println("For insert again type [Yes/NO]....");
		String option = input.next();
		if(option.equalsIgnoreCase("no"))
		{
			break;
		}
	}
	jrs.close();
	input.close();
	
			
	}
}