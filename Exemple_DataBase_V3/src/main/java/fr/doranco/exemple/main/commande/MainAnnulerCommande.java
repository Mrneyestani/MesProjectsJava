package fr.doranco.exemple.main.commande;

import java.util.List;

import fr.doranco.exemple.entity.Adresse;
import fr.doranco.exemple.entity.Commande;
import fr.doranco.exemple.enums.EtatCommandeEnum;
import fr.doranco.exemple.model.dao.CommandeDao;
import fr.doranco.exemple.model.dao.ICommandeDao;
import fr.doranco.exemple.utils.Dates;

public class MainAnnulerCommande {


	public static void main(String[] args) {
	
		try {
			final ICommandeDao commandeDao = new CommandeDao();
			int commandId = 4;
			Commande commande = commandeDao.getCommandeById(commandId);
			System.out.println("Annulation de la commande n°"+commandId+" : ");
			commande.setStatut(EtatCommandeEnum.ANNULEE.getValue());
			commande.setDateAnnulation(Dates.convertStringToDate("05/05/2023"));
			commandeDao.annulerCommande(commande);
			System.out.println("Commande n°"+commandId+ " est annulée.");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
