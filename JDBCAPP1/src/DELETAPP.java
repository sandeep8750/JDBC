import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class DELETAPP {
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//step 1. 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step 2.
		String url = "jdbc:mysql://localhost:3306/student";
		String username = "root";
		String password = "sandeep@8750";
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println("Connection with database is Established....");
		
		//step 3. 
		Statement statement = conn.createStatement(); 	
		System.out.println("Statement Object is created.....");
		
		//step 4. 
		String sqlDeletQuery = "Delete  from student_info where sid=2";
		int rowAffected = statement.executeUpdate(sqlDeletQuery);
		System.out.println("Number of Rows is effected :: " + rowAffected);
		
		//step 5. 
		statement.close();
		conn.close();
		System.out.println("Closing Resource.....");
	}

}
