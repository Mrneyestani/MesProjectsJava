package fr.doranco.tp7;



public class Technicien extends Employe{

	protected int unites;



	public Technicien(String nom, String prenom, int age, String dateEntree, int unites) {
		super(nom, prenom, age, dateEntree);
		this.unites = unites;
	}



	@Override
	public double calculerSalaire() {
		
		return unites * 5;
	}
	
	@Override
	public String getNomPrenom() {
		
		return "\n\tLe technicien "+super.getNomPrenom();
	}



	@Override
	protected double salaireMoyen() {
		// TODO Auto-generated method stub
		return 0;
	}


}
