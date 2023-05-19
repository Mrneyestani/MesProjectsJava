package fr.doranco.monprojet.entity;

import java.util.Arrays;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import fr.doranco.monprojet.cryptage.algo.AlgorithmeCryptage;
import fr.doranco.monprojet.enums.CryptageEnum;
import fr.doranco.monprojet.utils.Dates;

public class CartePaiement {

	private Integer id;
	private String titulaire;
	private byte[] numeroCarte;
	private Date dateValidite;
	private byte[] cryptogramme;
	private Integer userId;
	
	public CartePaiement() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulaire() {
		return titulaire;
	}

	public void setTitulaire(String titulaire) {
		this.titulaire = titulaire;
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

	@Override
	public String toString() {
		String dateValiditeStr = null;
		try {
			dateValiditeStr = Dates.dateToString(dateValidite);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "CartePaiement [id=" + id + ", titulaire=" + titulaire + ", numeroCarte=" + numeroCarte
				+ ", dateValidite=" + dateValiditeStr + ", cryptogramme=" + cryptogramme + ", userId="
				+ userId + "]";
	}
}
