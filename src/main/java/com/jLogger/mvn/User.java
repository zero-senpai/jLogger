package com.jLogger.mvn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;


public class User extends DBConfig {
	private String username;
	private String password;
	private long accountAge;
	
	
	//Default constructor
	public User() {
		this.username = "None";
		this.password = "empty";
		this.accountAge = 0;
	}
	
	//Constructor Overload - Information
	public User(String name, String pwd) {
		this.username = name;
		this.password = hashPassword(pwd);
	}
	
	private String hashPassword(String pwd) {
		return BCrypt.hashpw(pwd, BCrypt.gensalt());
	}
	
	public boolean checkPassword(String pwd) {
		return BCrypt.checkpw(pwd, password);
	}
	
	public void saveToDatabase() {
		try (
			Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			PreparedStatement statement = conn.prepareStatement(DTO.INSERT_USER);
		) {
			statement.setString(1,  username);
			statement.setString(2,  password);
			statement.executeUpdate();
			System.out.println("User was saved to the database!");
		} catch (SQLException e) {
			System.err.println("Failed to save user to DB: " + e.getMessage());
		}
	
	}
	
	
	//Getters and Setters
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String pwd) {
		this.password = pwd;
	}
	
	
	
}
