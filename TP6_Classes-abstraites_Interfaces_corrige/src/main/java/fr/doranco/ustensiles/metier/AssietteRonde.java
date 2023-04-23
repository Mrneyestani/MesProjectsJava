package fr.doranco.ustensiles.metier;

public class AssietteRonde extends Assiette {

	private float rayon;

	public AssietteRonde(int anneeCreation, float rayon) {
		super(anneeCreation);
		this.rayon = rayon;
	}

	@Override
	public float calculerSurface() {
		return PI * rayon * rayon;
	}
	
	
}
