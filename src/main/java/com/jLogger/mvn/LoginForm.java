package com.jLogger.mvn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginForm() {
        super("Login");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
        panel.add(loginButton);

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private void loginUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Perform authentication
        if (authenticateUser(username, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Login failed. Invalid username or password.");
        }
    }

    private boolean authenticateUser(String username, String password) {
        
    	String hashedPasswordFromDB = null;
    	Connection conn = null;
    	PreparedStatement statement = null;
    	ResultSet resultSet = null;
    	
    	try {
    		conn = DBConfig.getConnection();
    		statement = conn.prepareStatement(DTO.CHECK_PASS);
    		statement.setString(1,  username);
    		resultSet = statement.executeQuery();
    		if (resultSet.next()) {
    			hashedPasswordFromDB = resultSet.getString("password_hash");
    		}
    	} catch (SQLException e) {
    		System.err.println("Error authenticating user: " + e.getMessage());
    		return false;
    	} finally {
    		DBConfig.closeResultSet(resultSet);
    		DBConfig.closeStatement(statement);
    		DBConfig.closeConnection(conn);
    	}
    	
    	return hashedPasswordFromDB != null && BCrypt.checkpw(password, hashedPasswordFromDB);
    	
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginForm();
            }
        });
    }
}
