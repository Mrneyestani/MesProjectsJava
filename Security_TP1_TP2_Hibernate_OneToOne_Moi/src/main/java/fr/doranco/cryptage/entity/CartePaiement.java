package fr.doranco.cryptage.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class CartePaiement {
	private Integer id;
	private String numeroCarte;
	private Date dateValidite;
	private String cryptogramme;
	
	public CartePaiement() {
		
	}

	public CartePaiement(String numeroCarte, Date dateValidite, String cryptogramme) {
		
		this.numeroCarte = numeroCarte;
		this.dateValidite = dateValidite;
		this.cryptogramme = cryptogramme;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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


	public String getCryptogramme() {
		return cryptogramme;
	}


	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}


	@Override
	public String toString() {
		return "CartePaiement [numeroCarte=" + numeroCarte + ", dateValidite=" + dateValidite
				+ ", cryptogramme=" + cryptogramme + "]";
	}

	
	
}
