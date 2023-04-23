package fr.doranco.ustensiles.metier;

public final class Cuillere extends Ustensile {

	private float longueur;

	public Cuillere(int anneeCreation, float longueur) {
		super(anneeCreation);
		this.longueur = longueur;
	}

	public float getLongueur() {
		return longueur;
	}

	@Override
	public float calculerValeur() {
		return 2 * super.calculerValeur();
	}

	
}
