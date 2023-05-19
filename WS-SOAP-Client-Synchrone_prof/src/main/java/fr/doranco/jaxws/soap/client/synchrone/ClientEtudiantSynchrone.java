package fr.doranco.jaxws.soap.client.synchrone;

import java.util.List;

import fr.doranco.jaxws.soap.service.Etudiant;
import fr.doranco.jaxws.soap.service.EtudiantService;
import fr.doranco.jaxws.soap.service.EtudiantService_Service;

public class ClientEtudiantSynchrone {

	public static void main(String[] args) {

		try {
			EtudiantService_Service service = new EtudiantService_Service();
			EtudiantService ws = service.getEtudiantPort();

//			List<Etudiant> etudiants = ws.getEtudiants();
//			etudiants.forEach(e -> System.out.println(e));

			Etudiant etudiant = new Etudiant();
			etudiant.setNom("BLAISE");
			etudiant.setPrenom("Pascal");
			etudiant.setSpecialite("Ecrivain");
			
			Etudiant addedEtudiant = ws.addEtudiant(etudiant);
			System.out.println(addedEtudiant);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
