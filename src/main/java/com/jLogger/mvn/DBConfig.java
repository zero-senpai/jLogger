package com.jLogger.mvn;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public abstract class DBConfig {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "root";
	
}
