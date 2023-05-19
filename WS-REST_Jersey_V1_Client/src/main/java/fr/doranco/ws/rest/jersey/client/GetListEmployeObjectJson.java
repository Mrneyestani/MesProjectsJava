package fr.doranco.ws.rest.jersey.client;

import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import fr.doranco.ws.rest.jersey.entity.Employe;

public class GetListEmployeObjectJson {

	public static void main(String[] args) {

		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);

		WebResource webResource = client.resource("http://localhost:9991/rest/employes/all");
		
		Builder builder = webResource.accept(MediaType.APPLICATION_JSON)
					.header("Ma société", "Doranco");
		
		ClientResponse response = builder.get(ClientResponse.class);
		
		System.out.println("Code status : " + response.getStatus());
		
		if (response.getStatus() != 200) {
			System.out.println("Erreur ! code HTTP : " + response.getStatus());
		} else {
			List<Employe> employes = response.getEntity(new GenericType<List<Employe>>() {});
			System.out.println("Objet reçu : ");
			employes.forEach(e -> System.out.println(e));
		}
		System.exit(0);
	}

}
