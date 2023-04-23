package fr.doranco.ustensiles.metier;

public class AssietteCarre extends Assiette {

	private float longueurCote;

	public AssietteCarre(int anneeCreation, float longueurCote) {
		super(anneeCreation);
		this.longueurCote = longueurCote;
	}

	@Override
	public float calculerSurface() {
		return longueurCote * longueurCote;
	}

}
