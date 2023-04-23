package fr.doranco.poo.heritage.metier;

public class EtudiantEchange extends Etudiant {

	private String uniOrigine;

	public EtudiantEchange(String nom, int annee, String section, String uniOrigine) {
		super(nom, annee, section);
		this.uniOrigine = uniOrigine;
	}

	public void afficher() {
		System.out.println("Etudiant d'echange:");
		super.afficher();
		System.out.println("   Uni d'origine : " + getUniOrigine());
	}

	public String getUniOrigine() {
		return uniOrigine;
	}
}