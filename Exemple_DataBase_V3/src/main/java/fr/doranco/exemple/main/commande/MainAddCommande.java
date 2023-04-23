package fr.doranco.exemple.main.commande;

import fr.doranco.exemple.entity.Commande;
import fr.doranco.exemple.enums.EtatCommandeEnum;
import fr.doranco.exemple.enums.LivraisonCommandeEnum;
import fr.doranco.exemple.model.dao.CommandeDao;
import fr.doranco.exemple.model.dao.ICommandeDao;
import fr.doranco.exemple.utils.Dates;

public class MainAddCommande {

	

	public static void main(String[] args) {
		
		try {
			final ICommandeDao commandeDao = new CommandeDao();
			
			Commande commande3 = new Commande(104, EtatCommandeEnum.LIVREE.getValue(),LivraisonCommandeEnum.DOMICILE.getValue(),Dates.convertStringToDate("16/05/2023"),Dates.convertStringToDate("25/06/2023"));
			int id3 = commandeDao.addCommande(commande3, 1, 1, 1, 1);
			commande3.setId(id3);
			System.out.println("Commande ajouté au panier.");
			System.out.println(commande3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


