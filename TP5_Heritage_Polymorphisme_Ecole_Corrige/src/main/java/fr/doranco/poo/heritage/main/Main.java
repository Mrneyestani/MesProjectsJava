package fr.doranco.poo.heritage.main;

import java.util.List;

import fr.doranco.poo.heritage.metier.EPFLien;
import fr.doranco.poo.heritage.metier.Enseignant;
import fr.doranco.poo.heritage.metier.EtudiantEchange;
import fr.doranco.poo.heritage.metier.EtudiantRegulier;
import fr.doranco.poo.heritage.metier.Secretaire;
import fr.doranco.poo.heritage.model.Ecole;

public class Main {

	public static void main(String[] args) {
		
		Ecole epfl = new Ecole();
		
		int nbEtuditansReguliers = 0;
		
		List<EPFLien> personnes = epfl.getGens();
		personnes.add(new EtudiantRegulier("Gaston Peutimide", 2008, "SSC", 6.0));
		personnes.add(new EtudiantRegulier("Yvan Rattrapeur", 2009, "SSC", 2.5));
		personnes.add(new EtudiantEchange("Bjorn Borgue", 2010, "Informatique", "KTH"));
		personnes.add(new Enseignant("Mathieu Matheu", 1998, "LMEP", 10000, "Physique"));
		personnes.add(new Secretaire("Sophie Scribona", 1995, "LMT", 5000));
		epfl.afficherStatistiques();
		epfl.afficherEpfliens();
		
		for (EPFLien personne : personnes) {
			if (personne instanceof EtudiantRegulier) {
				nbEtuditansReguliers++;
			}
		}
		System.out.println("Le total des EPFLiens : " + personnes.size());
		System.out.println("Le nombre total des Etudiants réguliers : " + nbEtuditansReguliers);
	}
}
