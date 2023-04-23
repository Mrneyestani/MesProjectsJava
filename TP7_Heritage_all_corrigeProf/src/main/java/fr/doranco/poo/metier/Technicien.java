package fr.doranco.poo.metier;

public class Technicien extends Employe implements ISalaire {

	protected int nbUnitesRealisees;

	public Technicien() {
	}

	public Technicien(String nom, String prenom, 
				String email, int age, String dateEntree, int nbUnitesRealisees) {
		super(nom, prenom, email, age, dateEntree);
		this.nbUnitesRealisees = nbUnitesRealisees;
	}

	@Override
	public float calculerSalaire() {
		return nbUnitesRealisees * SALAIRE_UNITE;
	}

}
