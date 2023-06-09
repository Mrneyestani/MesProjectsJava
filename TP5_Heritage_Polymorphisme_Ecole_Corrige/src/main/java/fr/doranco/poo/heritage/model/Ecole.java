package fr.doranco.poo.heritage.model;

import java.util.ArrayList;
import java.util.List;

import fr.doranco.poo.heritage.metier.EPFLien;
import fr.doranco.poo.heritage.metier.Etudiant;
import fr.doranco.poo.heritage.metier.EtudiantEchange;
import fr.doranco.poo.heritage.metier.EtudiantRegulier;

public class Ecole {

	private int nbEtudiants;
	private List<EPFLien> gens = new ArrayList<EPFLien>();

	public final static int ANNEE = 2012;

	public Ecole() {
		this.gens = new ArrayList<EPFLien>();
	}

	public List<EPFLien> getGens() {
		return gens;
	}
	
//	public void add(EPFLien personne) {
//		gens.add(personne);
//		if (personne.estEtudiant()) {
//			++nbEtudiants;
//		}
//	}

	public void afficherStatistiques() {
		int nbAnneesTotal = 0;
		int nbEtudiants = 0;
		for (EPFLien personne : gens) {
			if (personne instanceof Etudiant) {
				nbAnneesTotal += ANNEE - personne.getAnnee();
				nbEtudiants++;
			}
		}
		System.out.println("Parmi les " + gens.size() + " EPFLiens, " + nbEtudiants + " sont des etudiants.");
		double moyen = (double) nbAnneesTotal / nbEtudiants;
		System.out.println("Ils sont ici depuis en moyenne " + moyen + " ans");
	}

	public void afficherEpfliens() {
		System.out.println("Liste des EPFLiens: ");
		for (EPFLien personne : gens)
			personne.afficher();
	}
}
