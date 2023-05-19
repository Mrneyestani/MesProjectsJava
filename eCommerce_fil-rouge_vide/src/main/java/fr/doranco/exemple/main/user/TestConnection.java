package fr.doranco.exemple.main.user;

import java.sql.Connection;

import fr.doranco.exemple.model.connection.DataBaseConnection;

public class TestConnection {

	public static void main(String[] args) {
		
		try {
			Connection connection = DataBaseConnection.getConnection();
			System.out.println(connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
