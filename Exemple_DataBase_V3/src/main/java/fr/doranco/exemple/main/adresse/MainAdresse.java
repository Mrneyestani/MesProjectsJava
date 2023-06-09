package fr.doranco.exemple.main.adresse;

import java.util.List;

import fr.doranco.exemple.entity.Adresse;
import fr.doranco.exemple.model.dao.AdresseDao;
import fr.doranco.exemple.model.dao.IAdresseDao;

public class MainAdresse {

	public static void main(String[] args) {

		try {
			final IAdresseDao adresseDao = new AdresseDao();

//			Adresse adresse1 = new Adresse("12", "Rue du canal", "Paris", "75000");
//			Adresse adresse2 = new Adresse("7", "Passage de la baie", "Marseille", "13000");
//			Adresse adresse3 = new Adresse("5", "Bd de la gare", "Lyon", "69000");
//
//			int id1 = adresseDao.addAdresse(adresse1, 1);
//			adresse1.setId(id1);
//			int id2 = adresseDao.addAdresse(adresse2, 1);
//			adresse2.setId(id2);
//			int id3 = adresseDao.addAdresse(adresse3, 1);
//			adresse3.setId(id3);
//			
//			System.out.println("Adresses ajoutées :");
//			System.out.println(adresse1);
//			System.out.println(adresse2);
//			System.out.println(adresse3);
			
//			System.out.println("Récupération d'une adresse :");
//			Adresse a = adresseDao.getAdresse(2);
//			System.out.println(a);
//
//			System.out.println("Mise à jour d'une adresse :");
//			a.setVille("Bordeaux");
//			a.setCodePostal("34000");
//			adresseDao.updateAdresse(a);
//			System.out.println("Mise à jour réussie.");
			
//			System.out.println("Supression d'une adresse :");
//			adresseDao.deleteAdresse(3);
//			System.out.println("Suppression réussie.");
//			
			System.out.println("Récupération de toutes les adresses :");
			List<Adresse> adresses = adresseDao.getAdresses(4);
			for (Adresse adr : adresses) {
				System.out.println("  -> " + adr);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
