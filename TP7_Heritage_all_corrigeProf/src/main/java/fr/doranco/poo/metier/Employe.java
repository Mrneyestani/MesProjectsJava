package fr.doranco.poo.metier;

public abstract class Employe {

	protected String nom;
	protected String prenom;
	protected String dateNaissance;
	protected String email;
	protected int age;
	protected String dateEntree;

	protected Employe() {
	}
	
	protected Employe(String nom, String prenom, String email, int age, String dateEntree) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.age = age;
		this.dateEntree = dateEntree;
	}

	public abstract float calculerSalaire();

	public String getNomPrenom() {
		return nom.toUpperCase() + " " + prenom.substring(0, 1).toUpperCase() + prenom.substring(1).toLowerCase();
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public String getDateEntree() {
		return dateEntree;
	}
	
	
}
