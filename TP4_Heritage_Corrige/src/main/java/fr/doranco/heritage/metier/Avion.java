package fr.doranco.heritage.metier;

import fr.doranco.heritage.enums.TypeMoteurAvionEnum;

public class Avion extends Vehicule {

	private int nbHeuresVol;
	private String typeMoteur;
	
	public Avion(String marque, int anneeAchat, float prixAchat,
			int nbHeuresVol, String typeMoteur) {
		
		super(marque, anneeAchat, prixAchat);
		this.nbHeuresVol = nbHeuresVol;
		this.typeMoteur = typeMoteur;
	}

	@Override
	public void afficher() {
		System.out.println("-------------- Avion à " + typeMoteur + " ------------");
		super.afficher();
		System.out.println("Nombre d'heures de vol : " + nbHeuresVol);
	}

	@Override
	public void calculerPrix(int annee) throws Exception {
		float decote;
		if (typeMoteur.equals(TypeMoteurAvionEnum.HELICES.getValue())) {
			decote = nbHeuresVol/100f;
		} else if (typeMoteur.equals(TypeMoteurAvionEnum.REACTION.getValue())) {
			decote = nbHeuresVol/1000f;
		} else {
			throw new IllegalArgumentException("Le type de moteur " + typeMoteur
					+ " est non géré !");
		}
		
	}
	
	

}
