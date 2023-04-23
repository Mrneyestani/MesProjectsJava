package fr.doranco.poo.metier;

public final class ManutentionnaireArisque extends Manutentionnaire 
						implements ISalaire {

	public ManutentionnaireArisque() {
	}
	
	public ManutentionnaireArisque(String nom, String prenom, 
			String email, int age, String dateEntree, int nbHeuresTravaillees) {
		super(nom, prenom, email, age, dateEntree,
				nbHeuresTravaillees);
	}

	@Override
	public float calculerSalaire() {
		return super.calculerSalaire() + PRIME_A_RISQUE;
	}

	
}
