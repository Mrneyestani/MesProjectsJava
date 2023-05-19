package fr.doranco.hibernate.model.dao.impl;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.hibernate.entity.Commande;
import fr.doranco.hibernate.model.connector.HibernateConnector;
import fr.doranco.hibernate.model.dao.interfaces.ICommandeDao;

public class CommandeDao implements ICommandeDao {

	@Override
	public void addcommande(Commande commande) throws Exception {
		
		Session session = HibernateConnector.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(commande);
			commande.getLignesCommande().forEach(lc -> session.save(lc));
			tx.commit();
			
		} catch (RollbackException e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		
	}

}
