package in.ineuron.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.RowSetFactory;

import in.ineuron.dto.Student;
import in.ineuron.jdbcOp.JdbcOP;

public class StudentDaoImpl implements IStudentDao {

	

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		PreparedStatement preparedStatement = null;
		Connection dbConnection = null;
		String Sqlquery = "insert into student.student_data(studentName,studentAge,Studentaddress) value(?,?,?)";
		try {
			 dbConnection = JdbcOP.getDbConnection();
			if (dbConnection != null) {
				preparedStatement = dbConnection.prepareStatement(Sqlquery);
			}	
			if(preparedStatement != null)
			{
				preparedStatement.setString(1, sname);
				preparedStatement.setInt(2, sage);
				preparedStatement.setString(3, saddress);
			}
			
			int rowaffected  = preparedStatement.executeUpdate();
			if (rowaffected == 1) {
				
				return "Record inserted successfully...";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Record not inserted...";
	}

	@Override
	public Student searchStudent(Integer sid) {
		Connection connection = null;
		PreparedStatement prepareStatement=null;
		ResultSet resultSet = null;
		Student student =  new Student();
		
		
		String sqlquery = "select * from student.student_data where id=?";
		try {
			Connection dbConnection = JdbcOP.getDbConnection();
			if (dbConnection != null) {
				 prepareStatement = dbConnection.prepareStatement(sqlquery);
			}
			
			if (prepareStatement != null) {
				prepareStatement.setInt(1, sid);
			}
			if (prepareStatement != null) {
				
				resultSet = prepareStatement.executeQuery();
			}
			if (resultSet != null) {
				
				if(resultSet.next()) {
				int id =  resultSet.getInt(1);
				String name  = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String address = resultSet.getString(4);
				
				
				student.setSid(id);
				student.setSname(name);
				student.setSage(age);
				student.setSaddress(address);
				
				}
				
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student ;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		Connection connection = null;
		PreparedStatement prepareStatement=null;
		ResultSet resultSet = null;
		Student student =  new Student();
		int Rowaffected = 0;
		
		
		String sqlquery = "UPDATE student.student_data SET studentName = ?, studentAge = ?, Studentaddress = ?  WHERE id = ?";
		try {
			Connection dbConnection = JdbcOP.getDbConnection();
			if (dbConnection != null) {
				 prepareStatement = dbConnection.prepareStatement(sqlquery);
			}
			
			
			if (prepareStatement != null) {
				prepareStatement.setString(1, sname);
				prepareStatement.setInt(2, sage);
				prepareStatement.setString(3, saddress);
				prepareStatement.setInt(4, sid);
				 Rowaffected  = prepareStatement.executeUpdate();
			}
		
				if(Rowaffected == 1)
				{
					return "success";
				}else {
					return "not found";
				}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "fail";
	}

	@Override
	public String deleteStudent(Integer sid) {
		
		Connection connection = null;
		PreparedStatement prepareStatement=null;
		ResultSet resultSet = null;
		Student student =  new Student();
		int Rowaffected = 0;
		
		
		String sqlquery = "delete from student.student_data where id=?";
		try {
			Connection dbConnection = JdbcOP.getDbConnection();
			if (dbConnection != null) {
				 prepareStatement = dbConnection.prepareStatement(sqlquery);
			}
			
			if (prepareStatement != null) {
				prepareStatement.setInt(1, sid);
			}
			if (prepareStatement != null) {
				
				 Rowaffected  = prepareStatement.executeUpdate();
			}
		
				if(Rowaffected == 1)
				{
					return "success";
				}else {
					return "not found";
				}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "fail";
	}
	

}
