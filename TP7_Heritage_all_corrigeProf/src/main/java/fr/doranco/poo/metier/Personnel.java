package fr.doranco.poo.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Personnel {

	private static List<Employe> employes = new ArrayList<Employe>();
	
	private Personnel() {
	}

	public static void ajouterEmploye(Employe employe) {
		employes.add(employe);
	}

	public static void supprimerEmployeByEmail(String email) {
		for (Employe employe : employes) {
			if (employe.getEmail().equals(email)) {
				employes.remove(employe);
				break;
			}
		}
	}

	public static double getSalaireMoyen() {
		double salaireTotal = 0;
		for (Employe employe : employes) {
			salaireTotal += employe.calculerSalaire();
		}
		return salaireTotal/employes.size();
	}

	public static void afficherSalaires() {
		for (Employe employe : employes) {
			float salaire = employe.calculerSalaire();
			System.out.println(employe.getNomPrenom() + " ("
					+ employe.getClass().getSimpleName() + ") : " + salaire);
		}
	}
	
	public static Map<String, List<Employe>> getEmployes() {
		
		List<Employe> vendeurs = new ArrayList<Employe>();
		List<Employe> representants = new ArrayList<Employe>();
		List<Employe> manutentionnaires = new ArrayList<Employe>();
		List<Employe> manutentionnairesArisque = new ArrayList<Employe>();
		List<Employe> techniciens = new ArrayList<Employe>();
		List<Employe> techniciensArisque = new ArrayList<Employe>();
		
		for (Employe employe : employes) {
			if (employe instanceof Vendeur) {
				vendeurs.add(employe);
			}
			if (employe instanceof Representant) {
				representants.add(employe);
			}
			if (employe instanceof Manutentionnaire) {
				manutentionnaires.add(employe);
			}
			if (employe instanceof ManutentionnaireArisque) {
				manutentionnairesArisque.add(employe);
			}
			if (employe instanceof Technicien) {
				techniciens.add(employe);
			}
			if (employe instanceof TechnicienArisque) {
				techniciensArisque.add(employe);
			}
		}
		
		Map<String, List<Employe>> mapEmployes = new HashMap<String, List<Employe>>();
		mapEmployes.put(Vendeur.class.getSimpleName(), vendeurs);
		mapEmployes.put(Representant.class.getSimpleName(), representants);
		mapEmployes.put(Manutentionnaire.class.getSimpleName(), manutentionnaires);
		mapEmployes.put(ManutentionnaireArisque.class.getSimpleName(), manutentionnairesArisque);
		mapEmployes.put(Technicien.class.getSimpleName(), techniciens);
		mapEmployes.put(TechnicienArisque.class.getSimpleName(), techniciensArisque);
		
		return mapEmployes;
	}
	
	public static float getSalaireMoyenByTypeEmploye(Employe employe) {

		float salaire = 0;
		int nbEmployes = 0;
		for (Employe e : employes) {
			String typeEmploye = employe.getClass().getSimpleName();
			if (e.getClass().getSimpleName().equals(typeEmploye)) {
				salaire += e.calculerSalaire();
				nbEmployes++;
			}
		}
		return salaire/nbEmployes;
	}

	
}
