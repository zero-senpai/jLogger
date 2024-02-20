package com.jLogger.mvn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame {
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	public Main() {
		super("User Add Form");
		JPanel panel = new JPanel(new GridLayout(3, 2));
		panel.add(new JLabel("Username: "));
		usernameField = new JTextField();
		panel.add(usernameField);
		panel.add(new JLabel("Password: "));
		passwordField = new JPasswordField();
		panel.add(passwordField);
	
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser();
			}
		});
		panel.add(addButton);
		
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 500);
		setLocationRelativeTo(null);
		setVisible(true);

	}
	
	private void addUser() {
		String username = usernameField.getText();
		String password = new String(passwordField.getPassword());
		
		User user = new User(username, password);
		user.saveToDatabase();
		
		JOptionPane.showMessageDialog(this, "User " + user + "Added!");
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}
	
}
