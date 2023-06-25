package in.ineron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.ineuron.jdbcOp.JdbcOP;
public class DateRetrivalApp {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Scanner input = null;
		Integer id = null;
		try {

			connection = JdbcOP.getDbConnection();

			String sqlSelectQurey = "select id , name , dob ,dom from student.users where id= ?";
			if (connection != null) {

				preparedStatement = connection.prepareStatement(sqlSelectQurey);

				if (preparedStatement != null) {
					input = new Scanner(System.in);
					if (input != null) {
						System.out.println("Enter user ID whose data you want to Retrive :: ");
						id = input.nextInt();
						preparedStatement.setInt(1, id);
					}
					resultSet = preparedStatement.executeQuery();

					if(resultSet != null)
					{
						if(resultSet.next())
						{
							int sid = resultSet.getInt(1);
							String name = resultSet.getString(2);
							java.sql.Date dob = resultSet.getDate(3);
							java.sql.Date dom = resultSet.getDate(4);
							
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							String strdob = sdf.format(dob);
							String strdom = sdf.format(dom);
							
							
							System.out.println(sid +"\t"+  name +"\t"+  strdob +"\t"+ strdom );
						}
						else {
							System.out.println("Record not found in database...");
						}
					}
					
					}
				}

		} catch (SQLException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcOP.resourceCleanUp(connection, preparedStatement, resultSet);
		}
	}

}
