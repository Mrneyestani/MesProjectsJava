package fr.doranco.cryptage.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;




public class User {
	
	private Integer id ;
	private String nom ;
	private String prenom ;
	private String email ;
	private byte[] password ;
	private String pw;
	private List<CartePaiment> cartesPaiment;
	
	
	public User() {
		cartesPaiment =new ArrayList<CartePaiment>(); 
	}


	public User(String nom, String prenom, String email, byte[] password) {
		cartesPaiment =new ArrayList<CartePaiment>(); 
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public byte[] getPassword() {
		return password;
	}


	public void setPassword(byte[] password) {
		this.password = password;
	}

	
	

	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public List<CartePaiment> getCartesPaiment() {
		return cartesPaiment;
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ Arrays.toString(password) +" , password decrypte =" + pw  + "]";
	}
	

}
