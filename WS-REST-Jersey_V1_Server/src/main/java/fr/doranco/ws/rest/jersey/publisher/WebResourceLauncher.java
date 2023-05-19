package fr.doranco.ws.rest.jersey.publisher;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

public class WebResourceLauncher {

	static final URI BASE_URI = UriBuilder.fromUri("http://localhost/rest").port(9991).build();

	public static void main(String[] args) {

		try {
			ResourceConfig config = new PackagesResourceConfig("fr.doranco.ws.rest.jersey.resources");
			System.out.println("Starting server : " + BASE_URI);
			HttpServer server = HttpServerFactory.create(BASE_URI, config);
			server.start();
			Thread.sleep(2000); // 2000 millisecondes => 2 secondes
			
			System.out.println("");
			System.err.println("  -> Jersey démarré avec succès.");
			System.err.println("  -> WADL disponible à l'adresse " + BASE_URI);
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("    Pour tester si le web service est bien déployé, vérifiez le lien : ");
			System.out.println("    => " + BASE_URI + "/application.wadl");
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
