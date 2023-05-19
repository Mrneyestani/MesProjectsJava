package fr.doranco.jaxws.client.asynchrone;

import java.util.concurrent.ExecutionException;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import fr.doranco.jaxws.webservice.AddEtudiantResponse;
import fr.doranco.jaxws.webservice.Etudiant;
import fr.doranco.jaxws.webservice.EtudiantService;
import fr.doranco.jaxws.webservice.EtudiantService_Service;

/**
 * @author Ryadh HADJ MOKHNECHE (hm_ryadh@yahoo.fr)
 */
public class ClientAsynchrone {

	public static void main(String[] args) {

		// initialisation du service et du port.
		EtudiantService_Service service = new EtudiantService_Service();
		EtudiantService port = service.getEtudiantPort();

		Etudiant etudiantToAdd = new Etudiant();
		etudiantToAdd.setNom("Paul");
		etudiantToAdd.setPrenom("SMITH");
		etudiantToAdd.setSpecialite("Mécanique");

		/*
		 * Asynchronous with callback handler (event)
		 */
		AsyncHandler<AddEtudiantResponse> asyncHandler = new AsyncHandler<AddEtudiantResponse>() {
			@Override
			public void handleResponse(Response<AddEtudiantResponse> res) {

				System.out.println("  -> Dans la méthode 'handleResponse(...)'");
				if (!res.isCancelled() && res.isDone()) { // pour savoir si la réponse est arrivée du serveur et n'a pas été annulée
					try {
						Etudiant etudiantAdded = res.get().getReturn();
						System.out.println("  -> Etudiant ajouté : " + etudiantAdded);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		System.out.println("  -> Appel de la méthode distante 'addEtudiant' with callback");
		port.addEtudiantAsync(etudiantToAdd, asyncHandler);
		System.out.println("  -> Appel effectué with callback");

		/*
		 * Asynchronous with polling mode ()
		 */
		try {
			System.out.println("  => Appel de la méthode distante 'addEtudiant' with polling");
			Response<AddEtudiantResponse> resp = port.addEtudiantAsync(etudiantToAdd);
			Thread.sleep(2000L);
			AddEtudiantResponse output = resp.get();
			System.out.println("  => Etudiant ajouté : " + output.getReturn());
		} catch (Exception exc) {
			System.out.println(exc.getClass().getName() + "  => polling for response : " + exc.getMessage());
		}

//		try {
//			System.out.println("  => Appel de la méthode distante 'addEtudiant' with polling");
//			Response<AddEtudiantResponse> resp = port.addEtudiantAsync(etudiantToAdd);
//			int i = 1;
//			while (!resp.isDone()) {
//				System.out.println("étape " + i++);
//			}
//			AddEtudiantResponse output = resp.get();
//			System.out.println("  => Etudiant ajouté : " + output.getReturn());
//		} catch (Exception exc) {
//			System.out.println(exc.getClass().getName() + "  => polling for response : " + exc.getMessage());
//		}
		
	}
}
