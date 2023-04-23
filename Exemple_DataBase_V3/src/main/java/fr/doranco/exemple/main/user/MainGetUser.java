package fr.doranco.exemple.main.user;

import java.util.List;

import fr.doranco.exemple.entity.Adresse;
import fr.doranco.exemple.entity.CartePaiement;
import fr.doranco.exemple.entity.Commande;
import fr.doranco.exemple.entity.User;
import fr.doranco.exemple.model.dao.IUserDao;
import fr.doranco.exemple.model.dao.UserDao;
import fr.doranco.exemple.utils.Dates;

public class MainGetUser {

	public static void main(String[] args) {

		try {
			 IUserDao userDao = new UserDao();
			User user = userDao.getUserById(1);
			System.out.println(user);
			for (Adresse a : user.getAdresses()) {
				System.out.println("  -> " + a);
			}
			for (CartePaiement c : user.getCartesPaiement()) {
				System.out.println("  -> " + c);
			}
			for (Commande cmd : user.getCommandes()) {
				System.out.println("  -> " + cmd);
			}
			
			System.out.println("========================");
			List<User> users = userDao.getUsers();
			for (User u : users) {
				System.out.println(u);
				for (Adresse a : u.getAdresses()) {
					System.out.println("  -> " + a);
				}
				for (CartePaiement c : u.getCartesPaiement()) {
					System.out.println("  -> " + c);
				}
				for (Commande cmd : u.getCommandes()) {
					System.out.println("  -> " + cmd);
				}
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
