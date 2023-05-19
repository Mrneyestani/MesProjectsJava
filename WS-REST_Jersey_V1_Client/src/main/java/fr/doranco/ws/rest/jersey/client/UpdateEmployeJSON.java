package fr.doranco.ws.rest.jersey.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import fr.doranco.ws.rest.jersey.entity.Employe;

public class UpdateEmployeJSON {

	public static void main(String[] args) {

		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);

		WebResource webResource = client.resource("http://localhost:9991/rest/employes/update");
		
		Builder builder = webResource.accept(MediaType.TEXT_PLAIN)
									.type(MediaType.APPLICATION_JSON)
									.header("Ma société", "Doranco");
		
		Employe employe = new Employe("BLAISE", "Pascal", "Ecrivain");
		employe.setId(10);
		ClientResponse response = builder.put(ClientResponse.class, employe);
		
		System.out.println("Code status : " + response.getStatus());
		
		if (response.getStatus() != 200) {
			System.out.println("Erreur ! code HTTP : " + response.getStatus());
		} else {
			String message = response.getEntity(String.class);
			System.out.println("Message reçu : " + message);
		}
		System.exit(0);
	}

}
