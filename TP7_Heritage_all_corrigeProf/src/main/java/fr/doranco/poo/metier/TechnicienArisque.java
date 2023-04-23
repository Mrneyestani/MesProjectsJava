package fr.doranco.poo.metier;

public final class TechnicienArisque extends Technicien 
						implements ISalaire {

	public TechnicienArisque() {
	}
	
	public TechnicienArisque(String nom, String prenom,
			String email, int age, String dateEntree, int nbUnitesRealisees) {
		super(nom, prenom, email, age, dateEntree,
				nbUnitesRealisees);
	}

	@Override
	public float calculerSalaire() {
		return super.calculerSalaire() + PRIME_A_RISQUE;
	}

	
}
