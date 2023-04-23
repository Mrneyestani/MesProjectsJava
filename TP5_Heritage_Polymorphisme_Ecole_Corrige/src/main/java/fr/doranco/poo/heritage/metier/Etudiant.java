package fr.doranco.poo.heritage.metier;

public class Etudiant extends EPFLien {

	private String section;

	public Etudiant(String nom, int annee, String section) {
		super(nom, annee);
		this.section = section;
	}

	public void afficher() {
		super.afficher();
		System.out.println("   Section : " + getSection());
	}

	public String getSection() {
		return section;
	}

	public boolean estEtudiant() {
		return true;
	}

}