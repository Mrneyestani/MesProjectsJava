package fr.doranco.exemple.enums;

public enum EtatCommandeEnum {

	ENCOURS ("En cours"),
	VALIDE ("Validée"),
	LIVREE ("Livrée"),
	ANNULEE ("Annulée");
	
	private String statut;

	private EtatCommandeEnum(String statut) {
		this.statut = statut;
	}

	public String getValue() {
		return statut;
	}
}
