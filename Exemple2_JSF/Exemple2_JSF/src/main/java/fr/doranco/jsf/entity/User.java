package fr.doranco.jsf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedProperty;

public class User {

	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String genre;
	private String email;
	private String password;
	private String niveauDeService;
	@ManagedProperty(value = "#{adressebean}")
	private List<Adresse> adresses =  new  ArrayList<Adresse>();
	private String telephone;
	private String fonctionActuelle;
	private String disponible;
	private String langagesSouhaite;

	
	public User() {
		// adresses = new  ArrayList<Adresse>();
	}

	public User(String nom, String prenom, Date dateDeNaissance, String genre, String email, String password,
			String niveauDeService, String telephone, String fonctionActuelle, String disponible,
			String langagesSouhaite) {

		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.genre = genre;
		this.email = email;
		this.password = password;
		this.niveauDeService = niveauDeService;
		this.telephone = telephone;
		this.fonctionActuelle = fonctionActuelle;
		this.disponible = disponible;
		this.langagesSouhaite = langagesSouhaite;
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

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
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

	public String getLangagesSouhaite() {
		return langagesSouhaite;
	}

	

	public List<Adresse> getAdresses() {
		return adresses;
	}

	@Override
	public String toString() {
		return "User [nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance + ", genre=" + genre
				+ ", email=" + email + ", password=" + password + ", niveauDeService=" + niveauDeService
				+ ", telephone=" + telephone + ", fonctionActuelle=" + fonctionActuelle + ", disponible=" + disponible
				+ ", langagesSouhaite=" + langagesSouhaite + "]";
	}



}
