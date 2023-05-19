package fr.doranco.cryptage.dao.impl;

import org.hibernate.Session;

import fr.doranco.cryptage.connector.HibernateConnector;
import fr.doranco.cryptage.dao.interfaces.ICartePaiementDao;
import fr.doranco.cryptage.entity.CartePaiementCrypte;

public class CartePaiementDao implements ICartePaiementDao {

//	@Override
//	public void addCartePaiement(CartePaiementCrypte cartePaiementCrypte, Integer userId) throws Exception {
//		
//		Session session = HibernateConnector.getSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			CartePaiementCrypte cartePaiementCrypte = new CartePaiementCrypte(cartePaiement);
//			session.save(cartePaiementCrypte);
//			tx.commit();
//			
//		} catch (RollbackException e) {
//			tx.rollback();
//		} finally {
//			if (session != null && session.isOpen()) {
//				session.close();
//			}
//		}
//		
//	}

	@Override
	public CartePaiementCrypte getCartePaiement(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		CartePaiementCrypte cartePaiement= null;
		try {
			cartePaiement = session.find(CartePaiementCrypte.class, id);
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return cartePaiement;
	}

}
