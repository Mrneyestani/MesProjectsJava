package fr.doranco.jsf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedProperty;

public class User {
	private Integer id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String genre;
	private String email;
	private String password;
	private String niveauDeService;
	@ManagedProperty(value = "#{adresseBean}")
	private List<Adresse> adresses;
	private String telephone;
	private String fonctionActuelle;
	private String nbAnneesExperience; 
	private String disponible;
	private List<String> langagesSouhaites;

	public User() {
		this.adresses = new ArrayList<Adresse>();
		this.langagesSouhaites = new ArrayList<String>();
	}

	public User(String nom, String prenom, Date dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	
	public User(String prenom, String nom, Date dateNaissance, String genre, String email, String password,
			String niveauDeService, String telephone, String fonctionActuelle,String nbAnneesExperience, String disponible) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.genre = genre;
		this.email = email;
		this.password = password;
		this.niveauDeService = niveauDeService;
		this.telephone = telephone;
		this.fonctionActuelle = fonctionActuelle;
		this.disponible = disponible;
		this.nbAnneesExperience = nbAnneesExperience;
		
		this.adresses = new ArrayList<Adresse>();
		this.langagesSouhaites = new ArrayList<String>();
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNiveauDeService() {
		return niveauDeService;
	}

	public void setNiveauDeService(String niveauDeService) {
		this.niveauDeService = niveauDeService;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFonctionActuelle() {
		return fonctionActuelle;
	}

	public void setFonctionActuelle(String fonctionActuelle) {
		this.fonctionActuelle = fonctionActuelle;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}



	public String getNbAnneesExperience() {
		return nbAnneesExperience;
	}

	public void setNbAnneesExperience(String nbAnneesExperience) {
		this.nbAnneesExperience = nbAnneesExperience;
	}

	public List<String> getLangagesSouhaites() {
		return langagesSouhaites;
	}

	@Override
	public String toString() {
		return "User [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", genre=" + genre
				+ ", email=" + email + ", password=" + password + ", niveauDeService=" + niveauDeService
				+ ", telephone=" + telephone + ", fonctionActuelle=" + fonctionActuelle + ", nbAnneesExperience="
				+ nbAnneesExperience + ", disponible=" + disponible + "]";
	}



	

}
