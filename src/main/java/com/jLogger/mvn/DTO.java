package com.jLogger.mvn;


/*
 *	The main Data transfer object
 *	@Usage: Multiple SQL statements and error handles 
 */


public class DTO {
	
	public final static String INSERT_USER = "INSERT INTO users (username, password_hash) VALUES (?, ?)";
	public final static String CHECK_PASS = "SELECT password_hash FROM users WHERE username = ?";
	
}
