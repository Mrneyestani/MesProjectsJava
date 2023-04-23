package fr.doranco.tp7;

public class Representant extends Commercial{

	

	public Representant(String nom, String prenom, int age, String dateEntree, double chiffreAffaire) {
		super(nom, prenom, age, dateEntree, chiffreAffaire);
		
	}

	@Override
	public double calculerSalaire() {
		
		return 800 + chiffreAffaire*20/100;
	}


	@Override
	public String getNomPrenom() {
		
		return "\n\tLe représentant "+super.getNomPrenom();
	}

	@Override
	protected double salaireMoyen() {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
