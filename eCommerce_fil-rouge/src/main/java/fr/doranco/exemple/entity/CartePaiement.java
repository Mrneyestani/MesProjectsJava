package fr.doranco.exemple.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CartePaiement {

	private Integer id;
	private String nomProprietaire;
	private String prenomProprietaire;
	private String numero;
	private String cryptogramme;
	private Date dateFinValidite;
	private Boolean isAvalaible;
	
	public CartePaiement() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getPrenomProprietaire() {
		return prenomProprietaire;
	}

	public void setPrenomProprietaire(String prenomProprietaire) {
		this.prenomProprietaire = prenomProprietaire;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public Date getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public Boolean isAvalaible() {
		return isAvalaible;
	}

	public void setIsAvalaible(Boolean isAvalaible) {
		this.isAvalaible = isAvalaible;
	}

	

}
