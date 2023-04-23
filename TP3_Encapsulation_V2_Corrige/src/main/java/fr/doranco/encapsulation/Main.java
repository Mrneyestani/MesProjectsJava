package fr.doranco.encapsulation;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
	
		Client client1 = new Client("HUGO", "Victor");

		Compte compte11 = new Compte(1000f, 0.01f);
		Compte compte12 = new Compte(2000f, 0.02f);
		Compte compte13 = new Compte(3000f, 0.03f);
		
		client1.getComptes().add(compte11);
		client1.getComptes().add(compte12);
		client1.getComptes().add(compte13);
		
		Client client2 = new Client("CAMUS", "Albert");

		Compte compte21 = new Compte(5000f, 0.05f);
		Compte compte22 = new Compte(6000f, 0.06f);
		Compte compte23 = new Compte(7000f, 0.07f);
		
		client2.getComptes().add(compte21);
		client2.getComptes().add(compte22);
		client2.getComptes().add(compte23);

		
		System.out.println("Solde actuel des comptes avant bouclage :");
		client1.afficherSoldes();
		client2.afficherSoldes();
		
		System.out.println();
		System.out.println("Bouclage de tous les comptes...");
		client1.bouclerComptes();
		client2.bouclerComptes();
		
		System.out.println();
		System.out.println("Solde des comptes après bouclage :");
		client1.afficherSoldes();
		client2.afficherSoldes();
	}

}
