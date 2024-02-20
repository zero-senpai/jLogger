package com.jLogger.mvn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DBConfig {

	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
	public static final String USERNAME = "admin";
	public static final String PASSWORD = "root";
	
	public static Connection getConnection() throws SQLException {
	   return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	}

	public static void closeConnection(Connection connection) {
	    if (connection != null) {
	       try {
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public static void closeStatement(PreparedStatement statement) {
	    if (statement != null) {
	        try {
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public static void closeResultSet(ResultSet resultSet) {
	    if (resultSet != null) {
	        try {
	             resultSet.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 }
}