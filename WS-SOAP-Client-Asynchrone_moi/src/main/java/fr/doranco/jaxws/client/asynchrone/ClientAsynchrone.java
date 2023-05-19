package fr.doranco.jaxws.client.asynchrone;

import java.util.concurrent.ExecutionException;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import fr.doranco.jaxws.service.AddEtudiantResponse;
import fr.doranco.jaxws.service.Etudiant;
import fr.doranco.jaxws.service.EtudiantService;
import fr.doranco.jaxws.service.EtudiantService_Service;


public class ClientAsynchrone {

	public static void main(String[] args) {
		EtudiantService_Service service = new EtudiantService_Service();
		EtudiantService port = service.getEtudiantPort();
		
		
		Etudiant etudiantToAdd = new Etudiant();
		etudiantToAdd.setNom("SMITH");
		etudiantToAdd.setPrenom("Paul");
		etudiantToAdd.setSpecialite("Mécanique");
		
		//Asynchrone with callback handler (event)
		AsyncHandler<AddEtudiantResponse> asyncHandler = new AsyncHandler<AddEtudiantResponse>() {

			@Override
			public void handleResponse(Response<AddEtudiantResponse> res) {
				System.out.println("  - > in handleResponse");
				if(!res.isCancelled() && res.isDone()) {
					try {
						Etudiant etudiantAdded = res.get().getReturn();
						System.out.println("    -> Etudiant ajouté : " +etudiantAdded);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
				
			}
		
		
		};
		
		System.out.println("   -> Appel de la méthode disstante 'addEtidiant' with callback ");
		port.addEtudiantAsync(etudiantToAdd, asyncHandler);
		System.out.println("  ->  Appel effectué with callback");

		//Asynchrone with polling mode()
		
		try {
			System.out.println("   -> Appel de la méthode disstante 'addEtidiant' with polling");
			Response<AddEtudiantResponse> resp = port.addEtudiantAsync(etudiantToAdd);
			Thread.sleep(2000L);
			AddEtudiantResponse output = resp.get();
			System.out.println("   -> Etudiant ajouté : " + output.getReturn());
			
			
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + "  => polling for response : " + e.getMessage());
		}
		
	}

}

