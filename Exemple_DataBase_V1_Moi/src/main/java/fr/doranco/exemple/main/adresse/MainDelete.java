package fr.doranco.exemple.main.adresse;

import fr.doranco.exemple.model.dao.IAdresseDao;
import fr.doranco.exemple.model.dao.AdresseDao;

public class MainDelete {

	public static void main(String[] args) {
		try {
			IAdresseDao adresseDao = new AdresseDao();
			adresseDao.deleteAdresse(3);
			System.out.println("suppression de l'adresse réussie.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
