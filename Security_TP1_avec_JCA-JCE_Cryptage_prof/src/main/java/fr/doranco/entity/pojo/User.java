package fr.doranco.entity.pojo;

import java.util.Arrays;

public class User {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private byte[] password;
	private byte[] cleCryptage;
	private CartePaiement cartePaiement;

	public User() {
	}

	public User(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
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

	public byte[] getCleCryptage() {
		return cleCryptage;
	}

	public void setCleCryptage(byte[] cleCryptage) {
		this.cleCryptage = cleCryptage;
	}

	public CartePaiement getCartePaiment() {
		return cartePaiement;
	}

	public void setCartePaiement(CartePaiement cartePaiement) {
		this.cartePaiement = cartePaiement;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ Arrays.toString(password) + ", cleCryptage=" + Arrays.toString(cleCryptage) + "]";
	}

}
