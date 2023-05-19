package fr.doranco.jsf.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User2 {

	private int id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	
//	private List<Adresse> adresses;
//	// variable cartesPaiment de type  List<CartePaiement>
//	private List<CartePaiement> cartesPaiment;
//	//liste de commandes dans l'entité User
//	private List<Commande> commandes ;

	public User2() {
//		adresses = new ArrayList<Adresse>();
//		//l'initialiser dans le constructeur
//		cartesPaiment = new ArrayList<CartePaiement>();
//		
//		//l'initialiser le constructeur
//		commandes = new ArrayList<Commande>();
	}
	
	public User2(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		
	}
	
	public User2(String nom, String prenom, Date dateNaissance) {
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

//	public List<Adresse> getAdresses() {
//		return adresses;
//	}
//	
//	//getter liste CartePaiement
//	public List<CartePaiement> getCartesPaiment() {
//		return cartesPaiment;
//	}
//	
//	//getter liste commandes
//	public List<Commande> getCommandes() {
//		return commandes;
//	}
//

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + "]";
	}

}
