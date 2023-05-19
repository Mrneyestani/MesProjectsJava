package fr.doranco.hibernate.main;

import fr.doranco.hibernate.entity.Article;
import fr.doranco.hibernate.model.dao.impl.ArticleDao;
import fr.doranco.hibernate.model.dao.interfaces.IArticleDao;

public class MainArticle {

	public static void main(String[] args) {
		
		final IArticleDao articleDao = new ArticleDao();
		
		try {
			Article article = new Article();
			article.setNom("RAM-8Go");
			article.setDescription("Mémoire RAM de 8 Go our PC");
			article.setPrix(70F);
			
			articleDao.addArticle(article);
			System.out.println(article);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
