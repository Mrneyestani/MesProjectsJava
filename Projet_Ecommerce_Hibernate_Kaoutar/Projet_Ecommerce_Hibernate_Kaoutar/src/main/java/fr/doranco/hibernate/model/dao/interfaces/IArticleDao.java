package fr.doranco.hibernate.model.dao.interfaces;

import fr.doranco.hibernate.entity.Article;

public interface IArticleDao {

	void addArticle(Article article) throws Exception;
	Article getArticle(Integer id) throws Exception;
}
