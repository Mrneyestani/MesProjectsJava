package fr.doranco.encapsulation;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
	
		Client client1 = new Client("HUGO", "Victor", 1000.00f, 0.01f, 2000.00f, 0.02f);
		Client client2 = new Client("CAMUS", "Albert", 3000.00f, 0.01f, 4000.00f, 0.02f);

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
