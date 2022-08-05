package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;;

public class LoginForm extends JFrame {

	private static final long serialVersionUID = 2879518785645742200L;
	private JTextField tfUsername;
	private JTextField tfPassword;
	static ResultSet rs = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LoginForm() {
		/*
		 * create window
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 400);
		getContentPane().setLayout(null);
		
		Label lblUsername = new Label("Benutzername");
		lblUsername.setBounds(100, 100, 80, 20);
		getContentPane().add(lblUsername);
		
		Label lblPassword = new Label("Kennwort");
		lblPassword.setBounds(100, 180, 80, 20);
		getContentPane().add(lblPassword);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(294, 101, 260, 20);
		getContentPane().add(tfUsername);
		tfUsername.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(294, 180, 260, 20);
		getContentPane().add(tfPassword);
		/*
		 * check login information
		 */
		JButton btnLogin = new JButton("Anmelden");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "Select * from Login where UserName=? and Passwort=?";
				try {
					Connection connection = new Connection();
					connection.establishLogin(query, tfUsername, tfPassword);
					if (rs.next()) {

					}
				} catch (SQLException err) {
						err.printStackTrace();
					}
			}
		});
		btnLogin.setBounds(388, 251, 166, 21);
		getContentPane().add(btnLogin);
	}
}
