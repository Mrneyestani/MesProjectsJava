package fr.doranco.tp7;

public class Main {


	public static void main(String[] args) {
		
		Personnel p = new Personnel();
		p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 30000));
		p.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 20000));
		p.ajouterEmploye(new Technicien("Yves", "Bossier", 28, "1998", 1000));
		p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocktout", 32, "1998", 45));
		p.ajouterEmploye(new TechnARisque("Jean", "Flippe", 28, "2000", 1000));
		p.ajouterEmploye(new ManutARisque("Karim", "Abordage", 30, "2001", 45));
		p.ajouterEmploye(new Vendeur("Piri", "Busio", 40, "1990", 20000));
		p.ajouterEmploye(new Representant("Ali", "Kireche", 35, "1997", 25000));
		System.out.print("\n---------------Les salaires des employées---------------\n");
		p.afficherSalaires();
		
		double moyen = p.salaireMoyen();
		System.out.println("\n-----------------Le salaire moyen----------------------\n");
		System.out.println("   Le salaire moyen dans l'entreprise est de "+ moyen + " euros.");
		
		p.afficherListSepare();

	}
	
}


//Fonctionalité getEmployé 
/*
 * Technicien = "Léon", "Vendtout" , "Jean", "Flippe"
 * Vendeur = "Pierre", "Business";
 * Vendeur = "Piri", "Busio";
 * Representant = "Pierre", "Business"
 * 
 */
/*
 * Boucler sur la list des employes
 * A chaque employe chercher sa categorie,
 * on ajoute le nom et le prenom dans la list de categori
 * refait une boucle sur chacun des categories employe et 
 * afficher le nom et prenom
 */

//Fonctionalité getMoyen par categori

/*
 * SalaireMoyn des vendeur = 3000;
 * 
 * prender en parametre le type demploye
 * Boucler sur la list des employes
 * on trouve les salaire 
 * on calcule le moyen
 * on affiche
 */
