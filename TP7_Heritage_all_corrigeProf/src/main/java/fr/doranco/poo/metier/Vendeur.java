package fr.doranco.poo.metier;

public final class Vendeur extends Commercial implements ISalaire {

	public Vendeur() {
	}
	
	public Vendeur(String nom, String prenom, String email,
			int age, String dateEntree, float chiffreDaffaires) {
		super(nom, prenom, email, age, dateEntree, chiffreDaffaires);
	}

	@Override
	public float calculerSalaire() {
		return super.calculerSalaire() + BONUS_VENDEUR;
	}
}
