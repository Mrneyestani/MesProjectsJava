package fr.doranco.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public final class CryptageDataSource {

	private static CryptageDataSource instance;

	private CryptageDataSource() {
	}

	public final Connection getConnection() throws Exception {

		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://127.0.0.1:3306/security_db_prof";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connexion = DriverManager.getConnection(url, user, password);
		return connexion;
	}

	public final static CryptageDataSource getInstance() {
		if (instance == null) {
			instance = new CryptageDataSource();
		}
		return instance;
	}

}
