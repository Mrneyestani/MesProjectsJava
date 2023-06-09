package fr.doranco.exemple.main.cartePaiement;

import java.util.List;

import fr.doranco.exemple.entity.Adresse;
import fr.doranco.exemple.entity.CartePaiement;
import fr.doranco.exemple.entity.User;
import fr.doranco.exemple.model.dao.CartePaiementDao;
import fr.doranco.exemple.model.dao.ICartePaiementDao;
import fr.doranco.exemple.model.dao.IUserDao;
import fr.doranco.exemple.model.dao.UserDao;
import fr.doranco.exemple.utils.Dates;

public class MainGetCarte {


	public static void main(String[] args) {
		
		try {
			final ICartePaiementDao cartePaiementDao = new CartePaiementDao();
			int id = 8;
			
			System.out.println("Récupération de la Carte numéroId : "+id);
			CartePaiement carte = cartePaiementDao.getCartePaiement(id);
			System.out.println(carte);
			
			int userId = 4;
			System.out.println("==================================================================");
			System.out.println("Récupération de toutes les cartes d'user numéro : "+userId);
			List<CartePaiement> cartes = cartePaiementDao.getCartesPaiement(userId);
			for (CartePaiement crt : cartes) {
				System.out.println("  -> " + crt);
			}
			
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
