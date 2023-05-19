package fr.doranco.utils;

public final class Strings {

	private Strings() {
	}
	
	public static boolean isStringOnlyAlphabet(String str) {

		    boolean isAlphabet = ((!str.equals(""))
		            && (str != null)
		            && (str.matches("^[a-zA-Z]*$")));
		    
		    return isAlphabet;
	}
}
