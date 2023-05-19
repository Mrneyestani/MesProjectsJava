package fr.doranco.ws.rest.jersey2.entity.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import fr.doranco.ws.rest.jersey2.entity.Employe;

public class GetEmployes {

	public static void main(String[] args) {
		
		ClientConfig config = new ClientConfig().register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target("http://localhost:9991/rest")
									.path("employes")
									.path("all");
		
		Response response = target.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.get();
		
		if (response.getStatus() == 200) {
			List<Employe> employes = response.readEntity(new GenericType<List<Employe>>() {});
			employes.forEach(e -> System.out.println(e));
		} else {
			String message = response.readEntity(String.class);
			System.out.println("ERROR : " + response.getStatus());
			System.out.println(message);
		}
	}
}
