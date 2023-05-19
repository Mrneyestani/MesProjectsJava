package fr.doranco.ws.rest.jersey2.entity.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import fr.doranco.ws.rest.jersey2.entity.Employe;

public class GetEmployeByEmail {

	private final static String CHARSET = ";charset=UTF-8";
	
	public static void main(String[] args) {
		
		ClientConfig config = new ClientConfig().register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target("http://localhost:9991/rest")
									.path("employes")
									.path("email")
									.path("blaise@gmail.com");
		
		Response response = target.request(MediaType.APPLICATION_JSON + CHARSET)
				.accept(MediaType.APPLICATION_JSON + CHARSET)
				.get();
		
		if (response.getStatus() == 200) {
			Employe employe = response.readEntity(Employe.class);
			System.out.println(employe);
		} else {
			System.out.println("ERROR : " + response.getStatus());
			System.out.println("Message d'erreur : " + response.getHeaderString("error"));
		}
	}
}
