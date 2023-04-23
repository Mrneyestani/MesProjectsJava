package fr.doranco.tp7;

public class TechnARisque extends Technicien implements IARisque{

	public TechnARisque(String nom, String prenom, int age, String dateEntree, int unites) {
		super(nom, prenom, age, dateEntree, unites);
	
	}

	public double calculerSalaire() {
		
		return unites * 5 + prime;
	}
	


}
