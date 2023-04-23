package fr.doranco.exemple.entity;

import java.util.Date;

public class CartePaiement {

	private int id;
	private String numeroCarte;
	private Date dateValidite;
	private int cryptogramme;
	
	
	public CartePaiement() {
		
	}


	public CartePaiement(String numeroCarte, Date dateValidite, int cryptogramme) {
		
		this.numeroCarte = numeroCarte;
		this.dateValidite = dateValidite;
		this.cryptogramme = cryptogramme;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumeroCarte() {
		return numeroCarte;
	}


	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}


	public Date getDateValidite() {
		return dateValidite;
	}


	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}


	public int getCryptogramme() {
		return cryptogramme;
	}


	public void setCryptogramme(int cryptogramme) {
		this.cryptogramme = cryptogramme;
	}


	@Override
	public String toString() {
		return "CartePaiement [id=" + id + ", numeroCarte=" + numeroCarte + ", dateValidite=" + dateValidite
				+ ", cryptogramme=" + cryptogramme + "]";
	}

	
	
}
