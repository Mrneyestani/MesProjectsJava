package fr.doranco.cryptage.main;

import org.hibernate.Session;

import fr.doranco.cryptage.connector.HibernateConnector;



public class TestHibernate {

	public static void main(String[] args) {

		try {
			Session session = HibernateConnector.getSession();
			System.out.println(session);
			if (session != null && session.isOpen()) {
				session.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
