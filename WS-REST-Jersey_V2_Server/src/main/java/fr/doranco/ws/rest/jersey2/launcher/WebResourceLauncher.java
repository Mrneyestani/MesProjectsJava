package fr.doranco.ws.rest.jersey2.launcher;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class WebResourceLauncher {

	final static URI BASE_URI = URI.create("http://localhost:9991/rest");

	public static void main(String[] args) {

		try {
			ResourceConfig config = new ResourceConfig().packages("fr.doranco.ws.rest.jersey2.server");
			ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
			HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, config);
			server.start();
			
			Thread.sleep(2000); // 2000 millisecondes => 2 secondes
			
			System.out.println("");
			System.err.println("  -> Jersey démarré avec succès.");
			System.err.println("  -> WADL disponible à l'adresse :");
			System.err.println("      => " + BASE_URI + "/application.wadl");
			System.out.println("");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
