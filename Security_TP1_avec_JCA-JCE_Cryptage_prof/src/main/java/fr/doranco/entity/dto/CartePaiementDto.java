package fr.doranco.entity.dto;

public class CartePaiementDto {
	private int id;
	private String nomComplet;
	private String numeroCarte;
	private String cryptogramme;
	private String dateValidite;
	
	public CartePaiementDto() {
	}

	public CartePaiementDto(String nomComplet, String numeroCarte, String cryptogramme, String dateValidite) {
		this.nomComplet = nomComplet;
		this.numeroCarte = numeroCarte;
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

	public String getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public String getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(String dateValidite) {
		this.dateValidite = dateValidite;
	}

}
