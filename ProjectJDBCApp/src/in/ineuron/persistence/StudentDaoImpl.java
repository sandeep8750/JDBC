package in.ineuron.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import in.ineuron.dto.Student;
import in.ineuron.jdbcOp.JdbcOP;


//Persistence logic using JDBC API
public class StudentDaoImpl implements IStudentDao {

	Connection connection = null;
	PreparedStatement pstmt = null;

	@Override
	public String addStudent(String sname, Integer sage, String saddress, String sgender) {

		String sqlInsertQuery = "insert  into student.student_info (`sname`,`sage`,`saddress`,`sgender`)values(?,?,?,?);";
		try {
			connection = JdbcOP.getDbConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);

			if (pstmt != null) {

				pstmt.setString(1, sname);
				pstmt.setInt(2, sage);
				pstmt.setString(3, saddress);
				pstmt.setString(4, sgender);

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return "failure";
	}

	@Override
	public Student searchStudent(Integer sid)  {
		
		Student std = null;
		try {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String sqlQuery = "select * from student.Student_info where sid = ? ";
			
			connection =  JdbcOP.getDbConnection();
			if(connection != null)
			{
				preparedStatement = connection.prepareStatement(sqlQuery);
			}
			if (preparedStatement != null) {		
				preparedStatement.setInt(1, sid );
				resultSet =  preparedStatement.executeQuery();										
			}
			if (resultSet != null) {
				
				if(resultSet.next())
				{
					std = new Student();
					if(std != null)
					{
						std.setSid(resultSet.getInt(1));
						std.setSname(resultSet.getString(2));
						std.setSage(resultSet.getInt(3));
						std.setSaddress(resultSet.getString(4));
						std.setSgender(resultSet.getString(5));
					}
				}
				return std;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return std;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		return null;
	}

	@Override
	public  String deleteStudent(Integer sid) {
	   Connection connection= null;
	   PreparedStatement preparedStatement = null;
	   String sqlQuery = null;
		
		try {
			sqlQuery = "Delete from student.student_info where sid = ? ";
		
			connection = JdbcOP.getDbConnection();
			if (connection  != null) {
				preparedStatement =  connection.prepareStatement(sqlQuery);
			}
			if(preparedStatement != null)
			{
				preparedStatement.setInt(1, sid);
			   int rowAffected = 	preparedStatement.executeUpdate();
			   if(rowAffected ==1 )
			   {
				   return "success";
			   }
			   else {
				   return "not found";
			   }
			}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return "failure";
	}
		return "failure";
	}

}
