package fr.doranco.heritage.metier;

import java.util.Calendar;

import fr.doranco.heritage.enums.MarqueVoitureEnum;

public class Voiture extends Vehicule {

	private float cylindree;
	private byte nbPortes;
	private int puissance;
	private int kilometrage;
	
	public Voiture(String marque, int anneeAchat, float prixAchat,
					float cylindree, byte nbPortes, int puissance, int kilometrage) {
		
		super(marque, anneeAchat, prixAchat);
		this.cylindree = cylindree;
		this.nbPortes = nbPortes;
		this.puissance = puissance;
		this.kilometrage = kilometrage;
	}

	@Override
	public void afficher() {
		System.out.println("-------------- Voiture " + super.marque + " ------------");
		super.afficher();
		System.out.println("Cylindree = " + cylindree
							+ ", Nombre de portes = " + nbPortes
							+ ", Puissance = " + puissance
							+ ", Kilométrage = " + kilometrage);
	}

	@Override
	public void calculerPrix(int annee) throws Exception {
		Calendar c = Calendar.getInstance();
		int anneeCourante = c.get(Calendar.YEAR);
		if (annee > anneeCourante || annee < anneeAchat) {
			throw new IllegalArgumentException("L'année de calcul doit être <= l'année courante"
					+ " et >= l'année d'achat !");
		}
		float decote = (annee - anneeAchat) * 0.02f;
		decote += 0.05f * (kilometrage/10000);
		
		if (super.marque.equals(MarqueVoitureEnum.FIAT.getValue())
				|| super.marque.equals(MarqueVoitureEnum.RENAULT.getValue())) {
			decote += 0.1f;
			
		} else if (super.marque.equals(MarqueVoitureEnum.FERRARI.getValue())
				|| super.marque.equals(MarqueVoitureEnum.PORSCHE.getValue())) {
			decote -= 0.2f;
		} else {
			throw new IllegalArgumentException(marque + " : n'est pas gérée par l'application !");
		}
		super.prixCourant = Math.max(0f, (1f - decote) * prixAchat);
	}


}
