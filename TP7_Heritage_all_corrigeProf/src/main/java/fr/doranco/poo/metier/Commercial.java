package fr.doranco.poo.metier;

public class Commercial extends Employe implements ISalaire {

	protected float chiffreDaffaires;

	protected Commercial() {
		super();
	}
	
	protected Commercial(String nom, String prenom, String email,
			int age, String dateEntree, float chiffreDaffaires) {
		super(nom, prenom, email, age, dateEntree);
		this.chiffreDaffaires = chiffreDaffaires;
	}

	@Override
	public float calculerSalaire() {
		return chiffreDaffaires * POURCETAGE_COMMERCIAL;
	}
	
	
}
