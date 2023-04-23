package fr.doranco.ustensiles.metier;

public abstract class Assiette extends Ustensile implements IAssiette {

	protected Assiette(int anneeCreation) {
		super(anneeCreation);
	}

	public float calculerValeur() {
		return 5 * super.calculerValeur();
	}

}
