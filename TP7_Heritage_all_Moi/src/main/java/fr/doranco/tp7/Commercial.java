package fr.doranco.tp7;

public abstract class Commercial extends Employe{

	protected double chiffreAffaire;
	
	
	
	
	public Commercial(String nom, String prenom, int age, String dateEntree, double chiffreAffaire) {
		super(nom, prenom, age, dateEntree);
		this.chiffreAffaire = chiffreAffaire;
		
	}


}
