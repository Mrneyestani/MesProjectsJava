package fr.doranco.exemple1;

public class Etudiant extends Personne {

	private String filiere;
	private String etablissement;

	public Etudiant(String nom, String prenom, int age, String filiere, String etablissement) {
		super(nom, prenom, age);
		this.filiere = filiere;
		this.etablissement = etablissement;
	}

	@Override
	public void afficherInfos() {
		System.out.println(super.nom + " " + super.prenom + " " + super.age + " "
				+ filiere + " " + etablissement);
	}
	
	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

}
