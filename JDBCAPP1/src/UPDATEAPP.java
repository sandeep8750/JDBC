import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class UPDATEAPP {
	
	  static int rowAffected ;
	 public static void main(String[] args) throws SQLException  {
		
		Connection connection= null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded man .....");
			
			String url       ="jdbc:mysql://localhost:3306/student";
			String username  ="root";
			String password  = "sandeep@8750";
		    connection =  DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established man.....");
			
			
			 statement = connection.createStatement();
			System.out.println("Statement Object is created man.....");

			String SQLQuery = "update student_info set sname='Sandeep' where sid = 1";
			String SQLQuery1 = "update student_info set sage=45 where sid = 10";
			 rowAffected =statement.executeUpdate(SQLQuery);
			 rowAffected =statement.executeUpdate(SQLQuery1);
				
			System.out.println("Number of Row is Updated :: " + rowAffected);
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();

		} catch(SQLException se) {
		se.printStackTrace();
		
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			statement.close();
			connection.close();		}
		
		
		
	}
}
