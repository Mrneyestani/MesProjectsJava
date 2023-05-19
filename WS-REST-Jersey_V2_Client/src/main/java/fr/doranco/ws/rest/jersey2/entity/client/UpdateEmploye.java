package fr.doranco.ws.rest.jersey2.entity.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import fr.doranco.ws.rest.jersey2.entity.Employe;

public class UpdateEmploye {

	private final static String CHARSET = ";charset=UTF-8";
	
	public static void main(String[] args) {
		
		ClientConfig config = new ClientConfig().register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target("http://localhost:9991/rest")
									.path("employes")
									.path("update");
		
		Employe employe = new Employe("CAMUS", "Albert", "Historien");
		employe.setId(8);
		employe.setEmail("camus@gmail.com");
		
		Response response = target.request(MediaType.APPLICATION_JSON + CHARSET)
				.put(Entity.entity(employe, MediaType.APPLICATION_JSON + CHARSET));
		
		if (response.getStatus() == Response.Status.ACCEPTED.getStatusCode()) {
			System.out.println(response.getHeaderString("message"));
			System.out.println(response.readEntity(Employe.class));
			
		} else {
			String error = response.getHeaderString("error");
			System.out.println("ERROR :");
			System.out.println("Code status = " + response.getStatus());
			System.out.println("message d'erreur = " + error);
		}
	}
}
