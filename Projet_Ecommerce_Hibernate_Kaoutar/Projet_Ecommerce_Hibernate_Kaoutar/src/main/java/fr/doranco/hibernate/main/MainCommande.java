package fr.doranco.hibernate.main;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import fr.doranco.hibernate.entity.Article;
import fr.doranco.hibernate.entity.Commande;
import fr.doranco.hibernate.entity.LigneCommande;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.dao.impl.ArticleDao;
import fr.doranco.hibernate.model.dao.impl.CommandeDao;
import fr.doranco.hibernate.model.dao.impl.UserDao;
import fr.doranco.hibernate.model.dao.interfaces.IArticleDao;
import fr.doranco.hibernate.model.dao.interfaces.ICommandeDao;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;

public class MainCommande {

	public static void main(String[] args) {
		
		IUserDao userDao = new UserDao();
		IArticleDao articleDao = new ArticleDao();
		ICommandeDao commandeDao = new CommandeDao();
		
		try {
			
			User user = userDao.getUserByEmail("blaise@gmail.com");
			
			Article article1 = articleDao.getArticle(1);
			Article article2 = articleDao.getArticle(2);
			
			LigneCommande ligneCommande1 = new LigneCommande();
			ligneCommande1.setArticle(article1);
			ligneCommande1.setQuantite(5);
			
			LigneCommande ligneCommande2 = new LigneCommande();
			ligneCommande2.setArticle(article2);
			ligneCommande2.setQuantite(4);
			
			Commande commande = new Commande();
			commande.setNumero("F20230509-001");
			
			Calendar cal = Calendar.getInstance();
			commande.setDateCreation(cal.getTime());

			cal.add(Calendar.DAY_OF_MONTH, 3);
			commande.setDateLivraison(cal.getTime());
			
			ligneCommande1.setCommande(commande);
			ligneCommande2.setCommande(commande);
			
			commande.getLignesCommande().add(ligneCommande1);
			commande.getLignesCommande().add(ligneCommande2);
			
			commande.setUser(user);
			//user.getCommandes().add(commande);
			
			commandeDao.addcommande(commande);
			System.out.println(user);
			System.out.println("  => " + commande);
			
			for (LigneCommande lc : commande.getLignesCommande()) {
				System.out.println("     -> " + lc);
				System.out.println("         * " + lc.getArticle());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
