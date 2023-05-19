package fr.doranco.monprojet.enums;

public enum SignatureEnum {

	DSA ("DSA"),
	RSA ("RSA");
	
	private String algorithme;
	
	private SignatureEnum(String algorithme) {
		this.algorithme = algorithme;
	}

	public String getAlgorithme() {
		return algorithme;
	}
	
}
