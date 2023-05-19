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

public class GetEmployeXML {

	public static void main(String[] args) {

		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);

		WebResource webResource = client.resource("http://localhost:9991/rest/employes/xml/5");
		
		Builder builder = webResource.accept(MediaType.TEXT_PLAIN)
					.header("content-type", MediaType.TEXT_PLAIN)
					.header("Ma société", "Doranco");
		
		ClientResponse response = builder.get(ClientResponse.class);
		
		System.out.println("Code status : " + response.getStatus());
		
		if (response.getStatus() != 200) {
			System.out.println("Erreur ! code HTTP : " + response.getStatus());
		} else {
			String message = response.getEntity(String.class);
			System.out.println("Message reçu : ");
			System.out.println(message);
		}
		System.exit(0);
	}

}
