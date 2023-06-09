package fr.doranco.exemple.entity;
import java.util.Date;

import fr.doranco.exemple.enums.EtatCommandeEnum;
import fr.doranco.exemple.enums.LivraisonCommandeEnum;
public class Commande {
	
	private int id; 
    private int numeroCommande;
    private Date dateLivraison;
    private Date dateCreation;
    private Date dateAnnulation;
    private String modeLivraison;
    private String statut;

	
	public Commande() {
		
	}
	

	public Commande(int numeroCommande, String statut,String modeLivraison, Date dateCreation, Date dateLivraison, Date dateAnnulation) {
		this.numeroCommande = numeroCommande;
		this.statut = statut;
		this.modeLivraison = modeLivraison;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.dateAnnulation = dateAnnulation;
	}
	
	public Commande(int numeroCommande, String statut,String modeLivraison, Date dateCreation, Date dateLivraison) {
		this.numeroCommande = numeroCommande;
		this.statut = statut;
		this.modeLivraison = modeLivraison;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumeroCommande() {
		return numeroCommande;
	}


	public void setNumeroCommande(int numeroCommande) {
		this.numeroCommande = numeroCommande;
	}


	public Date getDateLivraison() {
		return dateLivraison;
	}


	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Date getDateAnnulation() {
		return dateAnnulation;
	}


	public void setDateAnnulation(Date dateAnnulation) {
		this.dateAnnulation = dateAnnulation;
	}


	public String getModeLivraison() {
		return modeLivraison;
	}


	public void setModeLivraison(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	@Override
	public String toString() {
		return "Commande [id=" + id + ", numeroCommande=" + numeroCommande + ", dateLivraison=" + dateLivraison
				+ ", dateCreation=" + dateCreation + ", dateAnnulation=" + dateAnnulation + ", modeLivraison="
				+ modeLivraison + ", statut=" + statut + "]";
	}

	
}
