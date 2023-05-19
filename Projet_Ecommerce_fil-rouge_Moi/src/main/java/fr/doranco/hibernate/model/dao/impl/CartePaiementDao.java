package fr.doranco.hibernate.model.dao.impl;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.hibernate.entity.CartePaiment;
import fr.doranco.hibernate.model.connector.HibernateConnector;
import fr.doranco.hibernate.model.dao.interfaces.ICartePaiementDao;



public class CartePaiementDao implements ICartePaiementDao {

	@Override
	public void addCartePaiement(CartePaiment cartePaiement, Integer userId) throws Exception {
		
		Session session = HibernateConnector.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(cartePaiement);
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
	public CartePaiment getCartePaiement(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		CartePaiment cartePaiement= null;
		try {
			cartePaiement = session.find(CartePaiment.class, id);
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return cartePaiement;
	}

}
