package fr.doranco.tp7;



public class Vendeur extends Commercial{

	public Vendeur(String nom, String prenom, int age, String dateEntree, double chiffreAffaire) {
		super(nom, prenom, age, dateEntree, chiffreAffaire);
		
	}

	@Override
	public double calculerSalaire() {
		
		return 400 + chiffreAffaire*20/100;
	}

	@Override
	public String getNomPrenom() {
		
		return "\n\tLe vendeur "+super.getNomPrenom();
	}

	@Override
	protected double salaireMoyen() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
