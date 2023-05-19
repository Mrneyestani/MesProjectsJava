package fr.doranco.cryptage.dao.impl;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.cryptage.connector.HibernateConnector;
import fr.doranco.cryptage.dao.interfaces.ISecurityKey;
import fr.doranco.cryptage.entity.SecurityKey;

public class SecurityKeyDao implements ISecurityKey {
	
	@Override
	public void addSecurityKey(SecurityKey securityKey) throws Exception {

		Session session = HibernateConnector.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
//		
			session.save(securityKey);
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
	public SecurityKey getSecurityKeyById(Integer id) throws Exception {
		Session session = HibernateConnector.getSession();
		SecurityKey securityKey= null;
		try {
			securityKey = session.find(SecurityKey.class, id);
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return securityKey;

		
	}

}
