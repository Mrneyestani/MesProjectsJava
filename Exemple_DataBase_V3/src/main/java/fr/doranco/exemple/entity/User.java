package fr.doranco.exemple.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

	private int id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private List<Adresse> adresses;
	private List<CartePaiement> cartesPaiement;
	private List<Commande>commandes;

	public User() {
		adresses = new ArrayList<Adresse>();
		cartesPaiement = new ArrayList<CartePaiement>();
		commandes = new ArrayList<Commande>();
	}

	public User(String nom, String prenom, Date dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<CartePaiement> getCartesPaiement() {
		return cartesPaiement;
	}
	
	
	public List<Adresse> getAdresses() {
		return adresses;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", adresses=" + adresses + ", cartesPaiement=" + cartesPaiement + ", commandes=" + commandes + "]";
	}

	
	

}
