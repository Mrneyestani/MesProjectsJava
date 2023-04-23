package fr.doranco.encapsulation;

public class Client {

	private String nom;
	private String prenom;
	private Compte compte1;
	private Compte compte2;
	
	public Client(String nom, String prenom, float solde1, float taux1, float solde2, float taux2) {
		this.nom = nom;
		this.prenom = prenom;
		this.compte1 = new Compte(solde1, taux1);
		this.compte2 = new Compte(solde2, taux2);
	}
	
	public void afficherSoldes() {
		System.out.println(" => Client : " + nom + " " + prenom);
		System.out.println("      -> Compte 1 : " + compte1.getSolde());
		System.out.println("      -> Compte 2 : " + compte2.getSolde());
	}
	
	public void bouclerComptes() {
		compte1.boucler();
		compte2.boucler();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Compte getCompte1() {
		return compte1;
	}

	public void setCompte1(Compte compte1) {
		this.compte1 = compte1;
	}

	public Compte getCompte2() {
		return compte2;
	}

	public void setCompte2(Compte compte2) {
		this.compte2 = compte2;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", compte1=" + compte1 + ", compte2=" + compte2 + "]";
	}
	
}
