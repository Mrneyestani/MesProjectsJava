package fr.doranco.ustensiles.main;

import java.util.ArrayList;
import java.util.List;

import fr.doranco.ustensiles.metier.Assiette;
import fr.doranco.ustensiles.metier.AssietteCarre;
import fr.doranco.ustensiles.metier.AssietteRonde;
import fr.doranco.ustensiles.metier.Cuillere;
import fr.doranco.ustensiles.metier.Ustensile;

public class Main {

	public static void main(String[] args) {

		List<Ustensile> ustensiles = new ArrayList<Ustensile>();
		ustensiles.add(new AssietteRonde(1926, 8.4f));
		ustensiles.add(new Cuillere(1881, 7.3f));
		ustensiles.add(new AssietteCarre(1935, 5.6f));
		ustensiles.add(new Cuillere(1917, 8.8f));
		ustensiles.add(new AssietteRonde(1837, 5.4f));

		afficherNombreArticles(ustensiles);
		afficherSurfaceAssiettes(ustensiles);
		afficherValeurTotale(ustensiles);
	}

	static void afficherNombreArticles(List<Ustensile> listeUstensiles) {
		int nbCuilleres = 0;
		int nbAssiettesRondes = 0;
		int nbAssiettesCarre = 0;
		
		for (Ustensile ust : listeUstensiles) {
			if (ust instanceof Cuillere) {
				nbCuilleres++;
			}
			if (ust instanceof AssietteCarre) {
				nbAssiettesCarre++;
			}
			if (ust instanceof AssietteRonde) {
				nbAssiettesRondes++;
			}
		}
		System.out.println("Il y a " + nbCuilleres + " cuillères.");
		System.out.println("Il y a " + nbAssiettesCarre + " assiettes carrés.");
		System.out.println("Il y a " + nbAssiettesRondes + " assiettes rondes.");
	}

	static void afficherSurfaceAssiettes(List<Ustensile> listeUstensiles) {
		double surfaceTotale = 0;
		for (Ustensile ust : listeUstensiles) {
			if (ust instanceof Assiette) {
				surfaceTotale += ((Assiette) ust).calculerSurface();
			}
		}
		System.out.println("Surface totale des assiettes (carrés et rondes) : " + surfaceTotale);
	}

	static void afficherValeurTotale(List<Ustensile> listeUstensiles) {
		float valeurTotale = 0;
		for (Ustensile ust : listeUstensiles) {
			valeurTotale += ust.calculerValeur();
		}
		System.out.println("Valeur totale de la collection : " + valeurTotale);
	}
}
