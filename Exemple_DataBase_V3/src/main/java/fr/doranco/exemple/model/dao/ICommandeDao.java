package fr.doranco.exemple.model.dao;

import java.util.List;
import fr.doranco.exemple.entity.Commande;


public interface ICommandeDao {

	int addCommande(Commande commande,int userId, int adresseLivraisonId, int adresseFacturationId, int cartePaiementId) throws Exception;
	Commande getCommandeById(int id) throws Exception;
	List<Commande> getCommandes(int userId) throws Exception;
	void annulerCommande(Commande commande) throws Exception;
	void updateCommande(Commande commande) throws Exception;

}


