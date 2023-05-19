package fr.doranco.jaxws.service;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebService;

import fr.doranco.jaxws.entity.Etudiant;

@WebService(endpointInterface = "fr.doranco.jaxws.service.EtudiantService", serviceName = "EtudiantService",
					portName = "EtudiantPort")
public class EtudiantService implements IEtudiantService {

	@Override
	public Etudiant addEtudiant(Etudiant etudiant) throws Exception {

		System.out.println("  --> WebService 'addEtudiant' invoqué.");
		if (etudiant == null) {
			throw new NullPointerException("L'étudiant à créer doit être non NULL !");
		}
		if (etudiant.getNom() == null || etudiant.getNom().isEmpty()
				|| etudiant.getPrenom() == null || etudiant.getPrenom().isEmpty()
				|| etudiant.getSpecialite() == null || etudiant.getSpecialite().isEmpty()) {
			
			throw new IllegalArgumentException("Les paramètres 'nom', 'prenom' et 'spécialité'"
					+ " sont obligatoires !");
		}
		etudiant.setId(7);
		return etudiant;
	}

	@Override
	public Etudiant getEtudiantById(Integer id) throws Exception {

		System.out.println("  --> WebService 'getEtudiant' invoqué.");
		if (id == null) {
			throw new NullPointerException("L'id doit être non NULL !");
		}
		if (id <= 0) {
			throw new IllegalArgumentException("L'id doit être > 0 !");
		}
		Etudiant etudiant = new Etudiant("CAMUS", "Albert", "Historien", 78);
		return etudiant;
	}

	@Override
	public List<Etudiant> getEtudiants() throws Exception {
		
		System.out.println("  --> WebService 'getEtudiants' invoqué.");
		Etudiant etudiant1 = new Etudiant("CAMUS", "Albert", "Historien", 78);
		etudiant1.setId(5);
		Etudiant etudiant2 = new Etudiant("HUGO", "Victor", "Romancier", 80);
		etudiant2.setId(6);
		List<Etudiant> etudiants = Arrays.asList(etudiant1, etudiant2);
		return etudiants;
	}

}
