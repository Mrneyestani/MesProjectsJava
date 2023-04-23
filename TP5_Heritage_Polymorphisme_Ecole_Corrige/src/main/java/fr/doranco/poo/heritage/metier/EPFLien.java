package fr.doranco.poo.heritage.metier;

public class EPFLien {

	private String nom;
	private int annee;

	public EPFLien(String nom, int annee) {
		this.nom = nom;
		this.annee = annee;
	}

	public void afficher() {
		System.out.println("   Nom : " + getNom());
		System.out.println("   Annee : " + getAnnee());
	}

	public String getNom() {
		return nom;
	}

	public int getAnnee() {
		return annee;
	}

	public boolean estEtudiant() {
		return false;
	}

}