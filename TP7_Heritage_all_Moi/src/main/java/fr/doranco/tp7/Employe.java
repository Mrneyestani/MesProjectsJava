package fr.doranco.tp7;

public abstract class Employe {

	protected String nom;
	protected String prenom;
	protected int age;
	protected String dateEntree;
	
	public Employe() {
		
	}

	public Employe(String prenom, String nom, int age, String dateEntree) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.dateEntree = dateEntree;
	}
	
	public abstract double calculerSalaire();
	

	public String getNomPrenom() {
		return prenom.substring(0, 1).toUpperCase()+ prenom.substring(1).toLowerCase()
				+ " " + nom.toUpperCase() ;
	}

	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", prenom=" + prenom + "]";
	}

	protected abstract double salaireMoyen();
	
	

}
