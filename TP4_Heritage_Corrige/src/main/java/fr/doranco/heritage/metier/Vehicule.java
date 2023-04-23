package fr.doranco.heritage.metier;

public abstract class Vehicule {

	protected String marque;
	protected int anneeAchat;
	protected float prixAchat;
	protected float prixCourant;
	
	public Vehicule(String marque, int anneeAchat, float prixAchat) {
		this.marque = marque;
		this.anneeAchat = anneeAchat;
		this.prixAchat = prixAchat;
	}
	
	public void afficher() {
		System.out.println("Marque = " + marque
							+ ", Année d'achat = " + anneeAchat
							+ ", Prix d'achat = " + prixAchat
							+ ", Prix courant = " + prixCourant);
	}
	
	public void calculerPrix(int annee) throws Exception {
		float decote = (annee - anneeAchat) * 0.01f;
		prixCourant = Math.max(0f, (1f - decote) * prixAchat);
	}
}
