package fr.doranco.heritage.enums;

public enum TypeMoteurAvionEnum {

	HELICES ("Hélices"),
	REACTION ("Réaction");
	
	private String typeMoteur;

	private TypeMoteurAvionEnum(String typeMoteur) {
		this.typeMoteur = typeMoteur;
	}

	public String getValue() {
		return typeMoteur;
	}
	
	
}
