package fr.doranco.ustensiles.metier;

import java.time.LocalDate;

public abstract class Ustensile {

	protected int anneeCreation;

	protected Ustensile(int anneeCreation) {
		this.anneeCreation = anneeCreation;
	}

	public float calculerValeur() {

		LocalDate localDate = LocalDate.now();
		int anneActuelle = localDate.getYear();
		int age = anneActuelle - anneeCreation;

		float valeur = 0;

		// en utilisant le if/else
//		if (age > 50) {
//			valeur = age - 50;
//		}

		// en utilisant l'opérateur ternaire
//		valeur = age > 50 ? age - 50 : 0;

		// en utilisant la bibliotèque Math
		valeur = Math.max(age - 50, 0);

		return valeur;
	}
}
