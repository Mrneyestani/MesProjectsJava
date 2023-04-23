package fr.doranco.exemple.main.adresse;

import fr.doranco.exemple.entity.Adresse;
import fr.doranco.exemple.model.dao.AdresseDao;
import fr.doranco.exemple.model.dao.IAdresseDao;


public class MainGet {

	public static void main(String[] args) {
		try {
			IAdresseDao adresseDao = new AdresseDao();
			Adresse adresse = adresseDao.getAdresseById(6);
			System.out.println(adresse);
			
//			System.out.println("========================");
//			List<User> users = adresseDao.getAdresses();
//			for (User u : users) {
//				System.out.println(u);
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
