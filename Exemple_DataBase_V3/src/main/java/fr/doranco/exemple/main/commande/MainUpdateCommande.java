package fr.doranco.exemple.main.commande;

import java.util.List;

import fr.doranco.exemple.entity.Adresse;
import fr.doranco.exemple.entity.Commande;
import fr.doranco.exemple.enums.EtatCommandeEnum;
import fr.doranco.exemple.model.dao.CommandeDao;
import fr.doranco.exemple.model.dao.ICommandeDao;
import fr.doranco.exemple.utils.Dates;

public class MainUpdateCommande {


	public static void main(String[] args) {
	
		try {
			final ICommandeDao commandeDao = new CommandeDao();
			int commandId = 5;
			Commande commande = commandeDao.getCommandeById(commandId);
			System.out.println("Mise à jour du statut et de la date de livraison de la commande n°"+commandId+" : ");
			System.out.println("======================================================================");
			String statutCommande = EtatCommandeEnum.VALIDE.getValue();
			commande.setStatut(statutCommande);
			commande.setDateLivraison(Dates.convertStringToDate("20/05/2023"));
			commandeDao.updateCommande(commande);
			System.out.println("  -> Le statut est midifié : "+statutCommande);
			System.out.println("  -> La date de livraison est midifié : "+Dates.convertStringToDate("01/05/2023"));
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
