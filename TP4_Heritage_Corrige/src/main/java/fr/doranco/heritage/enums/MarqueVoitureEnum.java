package fr.doranco.heritage.enums;

public enum MarqueVoitureEnum {

	FIAT ("Fiat"),
	RENAULT ("Renault"),
	PEUGEOT ("Peugeot"),
	PORSCHE ("Porsche"),
	FERRARI ("Ferrari");
	
	private String marqueVoiture;

	private MarqueVoitureEnum(String marqueVoiture) {
		this.marqueVoiture = marqueVoiture;
	}

	public String getValue() {
		return marqueVoiture;
	}
}
