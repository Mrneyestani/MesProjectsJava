package fr.doranco.poo.main;

import java.util.List;
import java.util.Map;

import fr.doranco.poo.metier.Employe;
import fr.doranco.poo.metier.Manutentionnaire;
import fr.doranco.poo.metier.ManutentionnaireArisque;
import fr.doranco.poo.metier.Personnel;
import fr.doranco.poo.metier.Representant;
import fr.doranco.poo.metier.Technicien;
import fr.doranco.poo.metier.TechnicienArisque;
import fr.doranco.poo.metier.Vendeur;

public class Salaires {

	public static void main(String[] args) {
		
		Personnel.ajouterEmploye(new Vendeur("pierre", "business", "pierre@gmail.com", 45, "1995", 30000f));
		Personnel.ajouterEmploye(new Representant("léon", "vendtout", "leon@gmail.com", 25, "2001", 20000f));
		Personnel.ajouterEmploye(new Technicien("yves", "bossier", "yves@gmail.com", 28, "1998", 1000));
		Personnel.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocktout", "stocktout@gmail.com", 32, "1998", 45));
		Personnel.ajouterEmploye(new TechnicienArisque("Jean", "Flippe", "jean@gmail.com", 28, "2000", 1000));
		Personnel.ajouterEmploye(new ManutentionnaireArisque("Karim", "Abordage", "karim@gmail.com", 30, "2001", 45));
		Personnel.ajouterEmploye(new Vendeur("Piri", "Busio", "piri@gmail.com", 40, "1990", 20000f));

		
		
		System.out.println("======================================");
		System.out.println("Le salaire des employés :");
		Personnel.afficherSalaires();
		
		System.out.println("======================================");
		System.out.print("Le salaire moyen dans l'entreprise :");
		System.out.println(Personnel.getSalaireMoyen());
		
		System.out.println("======================================");
		System.out.println("La list des employés par type:");
		Map<String, List<Employe>> map = Personnel.getEmployes();
		
		for (Map.Entry<String, List<Employe>> entry : map.entrySet()) {
			String typeEmploye = entry.getKey();
			List<Employe> employes = entry.getValue();
			System.out.println(typeEmploye + " :");
			for (Employe e : employes) {
				System.out.println("  -> " + e.getNomPrenom());
			}
		}
		
		System.out.println("======================================");
		System.out.println("Le salaire moyen des employés par type:");
		float salaireV = Personnel.getSalaireMoyenByTypeEmploye(new Vendeur());
		System.out.println("Salaire moyen des vendeurs : " + salaireV);

		float salaireTR = Personnel.getSalaireMoyenByTypeEmploye(new TechnicienArisque());
		System.out.println("Salaire moyen des techniciens à risque : " + salaireTR);

		float salaireT = Personnel.getSalaireMoyenByTypeEmploye(new Technicien());
		System.out.println("Salaire moyen des techniciens : " + salaireT);
		
		float salaireR = Personnel.getSalaireMoyenByTypeEmploye(new Representant());
		System.out.println("Salaire moyen des representants : " + salaireR);
		
		float salaireM = Personnel.getSalaireMoyenByTypeEmploye(new Manutentionnaire());
		System.out.println("Salaire moyen des manutentionnaires : " + salaireT);
		
		float salaire = Personnel.getSalaireMoyenByTypeEmploye(new ManutentionnaireArisque());
		System.out.println("Salaire moyen des manutentionnaire à risquens : " + salaireT);

	}

}
