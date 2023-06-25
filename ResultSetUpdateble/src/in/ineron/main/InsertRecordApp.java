package in.ineron.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;

import in.ineuron.jdbcOp.JdbcOP;


public class InsertRecordApp {

	public static void main(String[] args) {

		// Resources used
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcOP.getDbConnection();

			if (connection != null)
				// Expecting ResultSet to be SCROLLABLE AND UPDATABLE
				stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			String sqlQuery = "select id,name,age,address from sandeep.employee";

			if (stmt != null)
				resultSet = stmt.executeQuery(sqlQuery);

			if (resultSet != null) {
				System.out.println("Records before insertion....");
				System.out.println("ID\tNAME\tAGE\tADDRESS");
				while (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));
				}

				resultSet.moveToInsertRow();
			
				resultSet.updateString(2, "Thala");
				resultSet.updateInt(3, 29);
				resultSet.updateString(4, "csk");
				resultSet.insertRow();

				System.out.println();
				resultSet.beforeFirst();// taking the cursor to BFR
				System.out.println("Records after insertion....");
				System.out.println("ID\tNAME\tAGE\tADDRESS");
				while (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));
				}
			}

		}  catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				JdbcOP.resourceCleanUp(connection, stmt, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
