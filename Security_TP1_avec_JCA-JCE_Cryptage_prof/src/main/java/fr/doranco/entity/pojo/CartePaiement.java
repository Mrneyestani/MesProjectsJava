package fr.doranco.entity.pojo;

import java.util.Arrays;
import java.util.Date;

public class CartePaiement {
	private int id;
	private String nomComplet;
	private byte[] cleCryptage;
	private byte[] numero;
	private byte[] cryptogramme;
	private Date dateValidite;
	
	public CartePaiement() {
	}

	public CartePaiement(String nomComplet, byte[] numeroCarte, byte[] cryptogramme, Date dateValidite) {
		this.nomComplet = nomComplet;
		this.numero = numeroCarte;
		this.cryptogramme = cryptogramme;
		this.dateValidite = dateValidite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public byte[] getCleCryptage() {
		return cleCryptage;
	}

	public void setCleCryptage(byte[] cleCryptage) {
		this.cleCryptage = cleCryptage;
	}

	public byte[] getNumero() {
		return numero;
	}

	public void setNumero(byte[] numero) {
		this.numero = numero;
	}

	public byte[] getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(byte[] cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public Date getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}

	@Override
	public String toString() {
		return "CartePaiement [id=" + id + ", nomComplet=" + nomComplet + ", numero=" + Arrays.toString(numero)
				+ ", cryptogramme=" + Arrays.toString(cryptogramme) + ", dateValidite=" + dateValidite + "]";
	}

}
