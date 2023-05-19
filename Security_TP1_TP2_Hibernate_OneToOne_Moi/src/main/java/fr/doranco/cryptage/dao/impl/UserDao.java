package fr.doranco.cryptage.dao.impl;

import javax.persistence.RollbackException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import fr.doranco.cryptage.connector.HibernateConnector;
import fr.doranco.cryptage.dao.interfaces.IUserDao;
import fr.doranco.cryptage.entity.User;

public class UserDao implements IUserDao {

	@Override
	public void addUser(User user) throws Exception {

		Session session = HibernateConnector.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user.getCartePaiementCrypte());
			session.save(user);
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
	public User getUserByEmail(String email) throws Exception {
		
		Session session = HibernateConnector.getSession();
		User user = null;
		try {
			// requête JPQL
//			Query<User> query = session.createQuery("FROM User u WHERE u.email = ?1", User.class);
//			query.setParameter(1, email);
//			user = query.uniqueResult();   //user = query.getSingleResult();

			// requête prédéfinie
			Query<User> query = session.createNamedQuery("User:findByEmail", User.class);
			query.setParameter("email", email);
			user = query.uniqueResult();
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}

}
