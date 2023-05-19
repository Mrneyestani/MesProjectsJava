package fr.doranco.hibernate.model.dao.impl;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.hibernate.entity.Article;
import fr.doranco.hibernate.model.connector.HibernateConnector;
import fr.doranco.hibernate.model.dao.interfaces.IArticleDao;

public class ArticleDao implements IArticleDao {

	@Override
	public void addArticle(Article article) throws Exception {
		
		Session session = HibernateConnector.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(article);
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
	public Article getArticle(Integer id) throws Exception {
		
		Session session = HibernateConnector.getSession();
		Article article = null;
		try {
			article = session.find(Article.class, id);
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return article;
	}

}
