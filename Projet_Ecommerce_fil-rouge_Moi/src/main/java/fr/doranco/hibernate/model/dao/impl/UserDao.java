package fr.doranco.hibernate.model.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.connector.HibernateConnector;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;

public class UserDao implements IUserDao {

	@Override
	public void addUser(User user) throws Exception {

		Session session = HibernateConnector.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			user.getCartesPaiemants().forEach(cp -> session.save(cp));
		//	user.getAdresses().forEach(a -> session.save(a));
			tx.commit();
			
		} catch (RollbackException e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public User getUserById(Integer id) throws Exception {
		
		Session session = HibernateConnector.getSession();
		User user = null;
		try {
			user = session.find(User.class, id);
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}

	@Override
	public void updateUser(User user) throws Exception {

		Session session = HibernateConnector.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
			
		} catch (RollbackException e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void deleteUser(User user) throws Exception {

		Session session = HibernateConnector.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.remove(user);
			tx.commit();
			
		} catch (RollbackException e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public List<User> getUsers() throws Exception {
		
		Session session = HibernateConnector.getSession();
		List<User> users = new ArrayList<User>();
		try {
			// requête JPQL
			//Query<User> query = session.createQuery("SELECT u FROM User u");
			//Query<User> query = session.createQuery("FROM User u", User.class);
			
			// requête Native (SQL)
			//Query<User> query = session.createNativeQuery("SELECT * FROM user", User.class);

			// requête prédéfinie
			Query<User> query = session.createNamedQuery("User:findAll", User.class);

			//users = query.getResultList();   // permet de récupérer quelques ou toutes les colonnes
			users = query.list();  // permet de récupérer toutes les colonnes
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return users;
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		
		Session session = HibernateConnector.getSession();
		User user = null;
		try {
			// requête JPQL
			Query<User> query = session.createQuery("FROM User u WHERE u.email = ?1", User.class);
			query.setParameter(1, email);
			user = query.uniqueResult();   //user = query.getSingleResult();

			// requête prédéfinie
//			Query<User> query = session.createNamedQuery("User:findByEmail", User.class);
//			query.setParameter("email", email);
//			user = query.uniqueResult();
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}

	@Override
	public List<User> getUsersOfVille(String ville) throws Exception {
		
		Session session = HibernateConnector.getSession();
		List<User> users = new ArrayList<User>();
		try {
			//Query<User> query = session.createQuery("FROM User u INNER JOIN Adresse a ON a.ville = :ville", User.class);
			Query<User> query = session.createQuery("FROM User u WHERE u.adresse.ville = :ville", User.class);
			query.setParameter("ville", ville);
			users = query.list();
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return users;
	}

	@Override
	public Map<String, List<User>> getUsersByVille() throws Exception {
		
		Session session = HibernateConnector.getSession();
		Map<String, List<User>> map = new HashMap<String, List<User>>();
		try {
			Query<String> query = session.createQuery("SELECT DISTINCT a.ville FROM Adresse a", String.class);
			List<String> villes = query.list();
			
			List<User> users = new ArrayList<User>();
			for (String ville : villes) {
				Query<User> query2 = session.createQuery("FROM User u WHERE u.adresse.ville = :ville", User.class);
				query2.setParameter("ville", ville);
				users = query2.list();
				map.put(ville, users);
			}
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return map;
	}

}
