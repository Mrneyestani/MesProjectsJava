package fr.doranco.exemple.main.cartePaiement;

import fr.doranco.exemple.entity.CartePaiement;
import fr.doranco.exemple.entity.User;
import fr.doranco.exemple.model.dao.CartePaiementDao;
import fr.doranco.exemple.model.dao.ICartePaiementDao;
import fr.doranco.exemple.model.dao.IUserDao;
import fr.doranco.exemple.model.dao.UserDao;
import fr.doranco.exemple.utils.Dates;

public class MainAddCarte {


	public static void main(String[] args) {
		
		try {
			final ICartePaiementDao cartePaiementDao = new CartePaiementDao();
			
			CartePaiement cartePaiement1 = new CartePaiement("5041721062014536", Dates.convertStringToDate("25/12/2024"), "978");
			CartePaiement cartePaiement2 = new CartePaiement("7891681062049934", Dates.convertStringToDate("20/11/2023"), "564");
			CartePaiement cartePaiement3 = new CartePaiement("3641728962744549", Dates.convertStringToDate("25/01/2025"), "325");
			
			int id1 = cartePaiementDao.addCartePaiement(cartePaiement1, 1);
			cartePaiement1.setId(id1);
			System.out.println("Carte Paiement ajouté avec succès :");
			System.out.println(cartePaiement1);
			
			int id2 = cartePaiementDao.addCartePaiement(cartePaiement2, 4);
			cartePaiement2.setId(id2);
			System.out.println("Carte Paiement ajouté avec succès :");
			System.out.println(cartePaiement2);
			
			int id3 = cartePaiementDao.addCartePaiement(cartePaiement3, 4);
			cartePaiement3.setId(id3);
			System.out.println("Carte Paiement ajouté avec succès :");
			System.out.println(cartePaiement3);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
