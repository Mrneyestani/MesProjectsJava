package fr.doranco.poo.heritage.metier;

public class Enseignant extends Personnel {

	private String section;

	public Enseignant(String nom, int annee, String labo, int salaire, String section) {
		super(nom, annee, labo, salaire);
		this.section = section;
	}

	public void afficher() {
		System.out.println("Enseignant:");
		super.afficher();
		System.out.println("   Section d'enseignement : " + getSection());
	}

	public String getSection() {
		return section;
	}
}