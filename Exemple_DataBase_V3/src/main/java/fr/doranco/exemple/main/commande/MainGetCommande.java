package fr.doranco.exemple.main.commande;

import java.util.*;

import fr.doranco.exemple.entity.Adresse;
import fr.doranco.exemple.entity.Commande;
import fr.doranco.exemple.enums.EtatCommandeEnum;
import fr.doranco.exemple.model.dao.CommandeDao;
import fr.doranco.exemple.model.dao.ICommandeDao;
import fr.doranco.exemple.utils.Dates;

public class MainGetCommande {


	public static void main(String[] args) {
	
		try {
			final ICommandeDao commandeDao = new CommandeDao();
			int commandId = 1;
			System.out.println("Récupération de la commande n°"+commandId+" : ");
			Commande c = commandeDao.getCommandeById(commandId);
			System.out.println("  -> " + c);
			
			System.out.println("==============================");
			int userId = 4;
			System.out.println("Récupération de toutes les commandes (non annulées) d'user n°"+userId+" : ");
			
			List<Commande> commandes = commandeDao.getCommandes(userId);
			for (Commande cds : commandes) {
				
				if (!cds.getStatut().equals(EtatCommandeEnum.ANNULEE.getValue())){
					
					System.out.println("  -> " + cds);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
