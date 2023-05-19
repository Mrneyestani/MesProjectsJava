package fr.doranco.cryptage.main;

import java.util.List;

import fr.doranco.cryptage.dao.CartePaiementDao;
import fr.doranco.cryptage.dao.ICartePaiementDao;

import fr.doranco.cryptage.dao.IUserDao;
import fr.doranco.cryptage.dao.UserDao;

import fr.doranco.cryptage.entity.CartePaiment;
import fr.doranco.cryptage.entity.User;





public class GetCartePaimentByIdUserMain {

	public static void main(String[] args) {
		try {
			final ICartePaiementDao cartePaimentDao = new CartePaiementDao();
			
//			System.out.println("Récupération de toutes les cartes de paimment par un utilisateur :  de l'id :1 ");
//			IUserDao userDao = new UserDao();
//			User user = userDao.getUserById(1);
//			System.out.println(user);
//			List<CartePaiment> cartesPaiement = cartePaimentDao.getCartesPaiements(1);
//			for (CartePaiment cp : cartesPaiement) {
//				System.out.println("  -> " + cp);
//			}
			
			
			IUserDao userDao = new UserDao();
			User user = userDao.getUserById(1);
			System.out.println(user);
			
			
			for (CartePaiment cp : user.getCartesPaiment()) {
				System.out.println("  -> " + cp);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
	}
		
	}

}
