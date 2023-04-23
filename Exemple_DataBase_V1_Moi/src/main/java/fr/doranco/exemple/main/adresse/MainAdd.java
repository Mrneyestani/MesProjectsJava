package fr.doranco.exemple.main.adresse;

import fr.doranco.exemple.entity.Adresse;
import fr.doranco.exemple.model.dao.AdresseDao;
import fr.doranco.exemple.model.dao.IAdresseDao;


public class MainAdd {


	public static void main(String[] args) {
		
		try {
			final IAdresseDao adresseDao = new AdresseDao();

			Adresse adresse = new Adresse("56", "Marcel Renault", "Paris", "75015");
			int id = adresseDao.addAdresse(adresse, 6);
			adresse.setId(id);
			System.out.println(adresse);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
