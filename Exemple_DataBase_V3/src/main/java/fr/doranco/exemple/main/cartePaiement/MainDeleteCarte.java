package fr.doranco.exemple.main.cartePaiement;

import fr.doranco.exemple.model.dao.CartePaiementDao;
import fr.doranco.exemple.model.dao.ICartePaiementDao;

public class MainDeleteCarte {


	public static void main(String[] args) {
		
		try {
			final ICartePaiementDao cartePaiementDao = new CartePaiementDao();

			int id = 6;
			System.out.println("Supression d'une carte :");
			cartePaiementDao.removeCartePaiement(id);
			System.out.println("Carte Paiement numéro "+id + " est supprimée avec succès.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
