package fr.doranco.users.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class User {

	private String nom;
	private String prenom;
	private String email;
	private String password;
	private Date dateNaissance;
	private Set<Adresse> adresses;
	
	public User() {
		this.adresses = new HashSet<Adresse>();
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	@Override
	public String toString() {
		return "User [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password
				+ ", dateNaissance=" + dateNaissance + "]";
	}
	
}
