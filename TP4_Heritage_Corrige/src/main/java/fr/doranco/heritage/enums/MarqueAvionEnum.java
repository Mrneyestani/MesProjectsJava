package fr.doranco.heritage.enums;

public enum MarqueAvionEnum {

	CESSNA ("Avion Cessna"),
	NAIN_CONNU ("Avion Nain Connu");
	
	private String marqueAvion;

	private MarqueAvionEnum(String marqueAvion) {
		this.marqueAvion = marqueAvion;
	}

	public String getValue() {
		return marqueAvion;
	}
	
}
