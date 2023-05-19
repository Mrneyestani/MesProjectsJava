package fr.doranco.jaxws.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DaoConnexion {

	private DaoConnexion() {
	}
	
	public static Connection getConnection() throws Exception {
		
		ResourceBundle rs = ResourceBundle.getBundle("dbfile");
		String user = rs.getString("user");
		String password = rs.getString("password");
		String url = rs.getString("url");
		String driver = rs.getString("driver");
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}
