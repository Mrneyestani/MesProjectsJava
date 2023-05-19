package fr.doranco.monprojet.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public final class MySqlDS {

	private static MySqlDS instance;
	
	private MySqlDS() {
	}
	
	public static MySqlDS getInstance() {
		if (instance == null) {
			instance = new MySqlDS();
		}
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		
		ResourceBundle rb = ResourceBundle.getBundle("fr.doranco.monprojet.model.mysql");
		String user = rb.getString("user");
		String password = rb.getString("password");
		String url = rb.getString("url");
		
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;

	}
	
}
