package fr.doranco.cryptage.connector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateConnector {

	private static HibernateConnector instance;
	private static SessionFactory sessionFactory;
	private static Session session;
	
	private HibernateConnector() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
	}
	
	public static Session getSession() {
		if (instance == null) {
			instance = new HibernateConnector();
		}
		if (session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
		}
		return session;
	}

}
