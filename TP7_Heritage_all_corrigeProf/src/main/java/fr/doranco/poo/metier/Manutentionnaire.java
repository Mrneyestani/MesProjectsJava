package fr.doranco.poo.metier;

public class Manutentionnaire extends Employe implements ISalaire {

	protected int nbHeuresTravaillees;

	public Manutentionnaire() {
	}

	public Manutentionnaire(String nom, String prenom, 
				String email, int age, String dateEntree, int nbHeuresTravaillees) {
		super(nom, prenom, email, age, dateEntree);
		this.nbHeuresTravaillees = nbHeuresTravaillees;
	}

	@Override
	public float calculerSalaire() {
		return nbHeuresTravaillees * SALAIRE_HORAIRE;
	}

}
