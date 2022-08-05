package code;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Connection extends JFrame {
	
	private static final long serialVersionUID = 1L;
	static java.sql.Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public void establishedConnection(String query) {
		String url = "jdbc:sqlserver://konzmannSQL:1433;databaseName=KonzCars;encrypt=true;trustServerCertificate=true;;user=KonzCars;password=KonzCars";
		try {
			System.out.println("connection was established");
			conn = DriverManager.getConnection(url);
			st = conn.prepareStatement(query);
			rs = st.executeQuery();
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,	err);
		}
	}
	
	public void establishLogin(String query, JTextField tfUsername, JTextField tfPassword) {
		String url = "jdbc:sqlserver://konzmannSQL:1433;databaseName=KonzCars;encrypt=true;trustServerCertificate=true;;user=KonzCars;password=KonzCars";
		try {
			conn = DriverManager.getConnection(url);
			st = conn.prepareStatement(query);
			st.setString(1, tfUsername.getText());
            st.setString(2, tfPassword.getText());
			rs = st.executeQuery();
		}
		catch(Exception err) {
			JOptionPane.showMessageDialog(null,	err);
		}
	}
}
