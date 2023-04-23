package fr.doranco.exemple.main.adresse;

import fr.doranco.exemple.entity.Adresse;
import fr.doranco.exemple.model.dao.AdresseDao;
import fr.doranco.exemple.model.dao.IAdresseDao;

public class MainUpdate {

	public static void main(String[] args) {
		try {
			IAdresseDao adresseDao = new  AdresseDao();
			 Adresse adresse = adresseDao.getAdresseById(3);
			adresse.setNumero("25");
			adresse.setRue("Victor");
			adresse.setVille("Paris");
			adresse.setCodePostal("75017");
			adresseDao.updateAdresse(adresse);
			System.out.println("Mise à jour réussie");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
