	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	
	public class Lunch1 {
	
	    public static void main(String[] args) {
	
	        Connection conn = null;
	        Statement statement = null;
	        ResultSet resultSet = null;
	        try {
	            // 1.step to importing all implementing class from Database
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Driver loaded sucessfully....");
	
	            // 2.step Build or Established Connection with Database
	            String url = "jdbc:mysql://localhost:3306/student";
	            String username = "root";
	            String password = "sandeep@8750";
	            conn = DriverManager.getConnection(url, username, password);
	            System.out.println("Connection Established.....");
	            System.out.println("The implement class Name is :: " + conn.getClass().getName());
	
	            // 3.step crate Object and send Query
	            String sqlSelectQuery = "select sid,sname,sage,saddress from student_info";
	            statement = conn.createStatement();
	            System.out.println("The implement class name is : " + statement.getClass().getName());
	
	            resultSet = statement.executeQuery(sqlSelectQuery);
	            System.out.println("The implement class name is : " + resultSet.getClass().getName());
	            
	            System.out.println();
	            // 4.step process the resultSet
	            while (resultSet.next()) {
	                Integer sid = resultSet.getInt(1);
	                String sname = resultSet.getString(2);
	                Integer sage = resultSet.getInt(3);
	                String saddress = resultSet.getString(4);

	                System.out.println(sid + "\t" + sname + "\t" + sage + "\t" + saddress);
	            }

	
	        } catch (ClassNotFoundException ce) {
	            ce.printStackTrace();
	        } catch (SQLException se) {
	            se.printStackTrace();
	        } catch (Exception ee) {
	            ee.printStackTrace();
	        }finally{
	            if(conn!=null)
	            {
	                try {
	                    conn.close();
	                } catch (SQLException se) {
	                    // TODO: handle exception
	                    se.printStackTrace();
	                }
	            }
	        }
	    }
	
	}
