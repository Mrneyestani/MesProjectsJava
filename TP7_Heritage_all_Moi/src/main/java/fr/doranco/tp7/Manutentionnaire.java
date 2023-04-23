package fr.doranco.tp7;


public class Manutentionnaire extends Employe{

	protected int heures;
	
	

	public Manutentionnaire(String nom, String prenom, int age, String dateEntree,int heures) {
		super(nom, prenom, age, dateEntree);
		this.heures = heures;
	}
	
	@Override
	public double calculerSalaire() {
		
		return 65 * heures;
	}

	@Override
	public String getNomPrenom() {
		
		return "\n\tLe Manutentionnaire "+super.getNomPrenom();
	}

	@Override
	protected double salaireMoyen() {
		
		return 0;
	}

}
