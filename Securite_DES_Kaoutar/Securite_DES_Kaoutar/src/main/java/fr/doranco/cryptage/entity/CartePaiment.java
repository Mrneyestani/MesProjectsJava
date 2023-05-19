package fr.doranco.cryptage.entity;

import java.util.Arrays;
import java.util.Date;

public class CartePaiment {
	
	private Integer id ;
	private byte[] numeroCarte ;
	private Date dateValidite ; 
	private byte[] cryptogramme;
	private Integer userId ;
	private String numeroCarteDecrypte;
	private String cryptogrammeDecrypte;
	
	public CartePaiment() {
		
	}

	public CartePaiment(byte[] numeroCarte, Date dateValidite, byte[] cryptogramme) {
		super();
		this.numeroCarte = numeroCarte;
		this.dateValidite = dateValidite;
		this.cryptogramme = cryptogramme;
		
	}




	public byte[] getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(byte[] cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public byte[] getNumeroCarte() {
		return numeroCarte;
	}


	public void setNumeroCarte(byte[] numeroCarte) {
		this.numeroCarte = numeroCarte;
	}


	public Date getDateValidite() {
		return dateValidite;
	}


	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}


	public Integer getuserId() {
		return userId;
	}


	public void setuserId(Integer userId) {
		this.userId = userId;
	}

	
	public String getNumeroCarteDecrypte() {
		return numeroCarteDecrypte;
	}

	public void setNumeroCarteDecrypte(String numeroCarteDecrypte) {
		this.numeroCarteDecrypte = numeroCarteDecrypte;
	}

	public String getCryptogrammeDecrypte() {
		return cryptogrammeDecrypte;
	}

	public void setCryptogrammeDecrypte(String cryptogrammeDecrypte) {
		this.cryptogrammeDecrypte = cryptogrammeDecrypte;
	}

	@Override
	public String toString() {
		return "CartePaiment [id=" + id +   ", dateValidite="
				+ dateValidite +   ", userId=" + userId
				+ ", numeroCarteDecrypte=" + numeroCarteDecrypte + ", cryptogrammeDecrypte=" + cryptogrammeDecrypte
				+ "]";
	}
	
	/*
	 * @Override
	public String toString() {
		return "CartePaiment [id=" + id + ", numeroCarte=" + Arrays.toString(numeroCarte) + ", dateValidite="
				+ dateValidite + ", cryptogramme=" + Arrays.toString(cryptogramme) + ", userId=" + userId
				+ ", numeroCarteDecrypte=" + numeroCarteDecrypte + ", cryptogrammeDecrypte=" + cryptogrammeDecrypte
				+ "]";
	}*/

	
}
