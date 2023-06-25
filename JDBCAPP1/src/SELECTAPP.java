import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SELECTAPP {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1.step=> to load Driver of database which is implemented by dbvendor
		//for java developer for their interface which written inside java for database communication 
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver of mysql database is loaded ");
		
		
		//2.step=> to build/Established connection from database using DriverManager class implementing by dbvendors 
		String url = "jdbc:mysql://localhost:3306/student";
		String username = "root";
		String password = "sandeep@8750";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		
		//3.step=> create statement Object to send request to database regarding our work 
		Statement statement = conn.createStatement();
		
		
		//4.step=> Execute the query and process the resultset 
		String sqlQuery = "select * from student_info";
		ResultSet resultSet = statement.executeQuery(sqlQuery);
		
		System.out.println("\n");
		System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
		
		while(resultSet.next()) {
			
			Integer sid = resultSet.getInt("sid");
			String  sname = resultSet.getString("sname");
			Integer sage = resultSet.getInt("sage");
			String  saddress =resultSet.getString("saddress");
			System.out.println(sid +"\t"+sname+"\t"+sage+"\t"+saddress);
			
		}
		
		//6.step=> is close the resource and objects
		resultSet.close();
		statement.close();
		conn.close();
		
	}

}
