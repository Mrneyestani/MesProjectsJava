package fr.doranco.encapsulation;

public class Compte {

	private float taux;
	private float solde;
	
	public Compte() {
	}

	public Compte(float solde, float taux) {
		this.solde = solde;
		this.taux = taux;
	}

	public void boucler() {
		solde = solde + solde * taux; // permet d'ajouter les interets au solde
		// ou on fait :
		//solde = solde * (1 + taux);
		// ou on fait :
		//solde *= 1 + taux;
	}
	
	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [taux=" + taux + ", solde=" + solde + "]";
	}
}
