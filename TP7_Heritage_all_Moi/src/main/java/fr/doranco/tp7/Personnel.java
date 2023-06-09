package fr.doranco.tp7;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Personnel {

	private List<Employe> personnels = new ArrayList<Employe>();
	private HashMap<String, List<Employe>> listEmployesSepare = new HashMap<String, List<Employe>>();
	private int nbreEmploye;
	private int maxEmploye;
	

	public Personnel() {
		this.personnels = new ArrayList<Employe>();
		this.listEmployesSepare = new HashMap<String, List<Employe>>();
	}

	public List<Employe> Employe() {
		return personnels;
	}

	public void ajouterEmploye(Employe personne) {
		personnels.add(personne);
		nbreEmploye++;
	}

//	public HashMap<String, List<Employe>> getListEmployesSepare() {
//		for (Employe l : personnels) {
//			if (l instanceof Vendeur) {
//				listEmployesSepare.put("Vendeur", listVendeur);
//				
//			}
//			else if (l instanceof Representant) {
//				listEmployesSepare.put("Representant",listRepresantant );
//			}
//			else if (l instanceof Technicien) {
//				listEmployesSepare.put("Technicien", listTechnicien);
//			}
//			else if (l instanceof Manutentionnaire) {
//				listEmployesSepare.put("Manutentionnaire", listManutentionnaire);
//			}
//			else if (l instanceof TechnARisque) {
//				listEmployesSepare.put("TechnARisque", listTechnARisque);
//			}
//			else if (l instanceof ManutARisque) {
//				listEmployesSepare.put("ManutARisque", listManutARisque);
//			}
//			
//		}
//		return listEmployesSepare;
//	}

	public void afficherListSepare() {
		List<String> listVendeur = new ArrayList<String>();
		List<String> listRepresentant= new ArrayList<String>();
		List<String> listTechnicien = new ArrayList<String>();
		List<String> listManutentionnaire = new ArrayList<String>();
		
		
		for (Employe person : personnels) {
			
			if (person instanceof Vendeur) {
				listVendeur.add(person.getNomPrenom());
				
			}
			if (person instanceof Representant) {
				listRepresentant.add(person.getNomPrenom());
			}
			if (person instanceof Technicien) {
				listTechnicien.add(person.getNomPrenom());
			}
			if (person instanceof Manutentionnaire) {
				listManutentionnaire.add(person.getNomPrenom());
			}	
		
		}
		
		System.out.println("\n------------list des vendeurs ---------------");
		afficher(listVendeur);
		
		System.out.println("\n------------list des representants ------------");
		afficher(listRepresentant);
		
		System.out.println("\n------------list des techniciens -------------");
		afficher(listTechnicien);
		
		System.out.println("\n------------list des manutentionnaires --------");
		afficher(listManutentionnaire);
		
	}
	
	
	
	public void afficher(List<String> myList) {
		
		for (String string : myList) {
			System.out.println(string);
			
		}
	}

//	public double getSalaireMoyenByTypeEmploye(Employe) {
//		double salaire = 0;
//		int nbperson = 0;
//		for (Employe employer : personnels) {
//				if (employe instanceof Employe) {
//				salaire += employer.calculerSalaire();
//				nbperson++;
//			}
//		}
//			return salaire / nbperson;
//	}
	
	
	
	public void afficherSalaires() {

		double salaire = 0;
		String nom;
		for (Employe personne : personnels) {
			salaire = personne.calculerSalaire();
			nom = personne.getNomPrenom();
			
			System.out.println(nom + " gagne " + salaire + " euros.");
		}
	}

	public double salaireMoyen() {
		double salaireTotal = 0;
		for (Employe personne : personnels) {
			salaireTotal += personne.calculerSalaire();
			
		}
		return salaireTotal / personnels.size();
		
	}

	public List<Employe> getPersonnels() {
		return personnels;
	}

}
