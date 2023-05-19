package fr.doranco.jsf.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public final class DataBaseConnection {

	private DataBaseConnection() {
	}
	
	public static Connection getConnection() throws Exception {
		
		ResourceBundle rs = ResourceBundle.getBundle("dbfile");
		String user = rs.getString("user");
		String password = rs.getString("password");
		String url = rs.getString("url");
		
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}
