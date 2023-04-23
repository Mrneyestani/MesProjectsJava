package fr.doranco.tp7;

public class ManutARisque extends Manutentionnaire implements IARisque{

	public ManutARisque(String nom, String prenom, int age, String dateEntree, int heures) {
		super(nom, prenom, age, dateEntree, heures);
		
	}


	public double calculerSalaire() {
	
		return prime + heures * 65 ;
	}

	
	

}
