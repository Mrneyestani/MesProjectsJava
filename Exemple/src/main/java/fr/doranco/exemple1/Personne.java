package fr.doranco.exemple1;

public abstract class Personne {

	protected String nom;
	protected String prenom;
	protected int age;

	public Personne(String nom, String prenom, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public void afficherInfos() {
		System.out.println(nom + " " + prenom + " " + age);
	}
}
