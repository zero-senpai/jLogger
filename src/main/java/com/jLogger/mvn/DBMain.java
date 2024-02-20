package com.jLogger.mvn;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * The main DB Connector class and fields.
 * @Usage: Connects to our MySQL Database.
 * #TODO: Add implementation to allow user to define their own MySQL server.
 **/


public class DBMain {

	
	public static void main(String[] args) {
		
		//Create connection
		try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			if (conn != null) {
				System.out.println("Connected to MySQL DB");
			} else {
				System.out.println("Could not connect to MySQL!");
			}
		} catch (SQLException e) {
			System.err.println("Connection failed!!!!");
			e.printStackTrace();
		}
		
		return;
	}
	
	
	
}
