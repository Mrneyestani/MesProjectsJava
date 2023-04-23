package fr.doranco.exemple.enums;

public enum LivraisonCommandeEnum {

	DOMICILE ("Domicile"),
	EXPRESS  ("Express"),
	RELAIS ("Relais");
	
	private String modeLivraison;

	private LivraisonCommandeEnum(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}

	public String getValue() {
		return modeLivraison;
	}
	
}
