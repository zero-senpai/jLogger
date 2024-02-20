package com.jLogger.mvn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;


public class User extends DBConfig {
	private String username;
	private String password;
	private int age;
	private long accountAge;
	
	
	//Default constructor
	public User() {
		this.username = "None";
		this.password = "empty";
		this.age = 0;
		this.accountAge = 0;
	}
	
	//Constructor Overload - Information
	public User(String name, String pwd, int ageYears) {
		this.username = name;
		this.password = hashPassword(pwd);
		this.age = ageYears;
	}
	
	private String hashPassword(String pwd) {
		return BCrypt.hashpw(pwd, BCrypt.gensalt());
	}
	
	public boolean checkPassword(String pwd) {
		return BCrypt.checkpw(pwd, password);
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
