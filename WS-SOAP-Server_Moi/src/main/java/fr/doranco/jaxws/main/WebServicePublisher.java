package fr.doranco.jaxws.main;

import javax.xml.ws.Endpoint;

import fr.doranco.jaxws.service.CoursService;
import fr.doranco.jaxws.service.EtudiantService;

public class WebServicePublisher {

	public static void main(String[] args){

		try {
			System.out.println("Publication du service web 'EtudiantService' en cours...");
			
			String link1 = "http://localhost:9991/ws/soap/etudiant-service";
			Endpoint.publish(link1, new EtudiantService());

			String link2 = "http://localhost:9991/ws/soap/cours-service";
			Endpoint.publish(link2, new CoursService());

			System.out.println("Web services publiés avec succès.");
			System.out.println("======================================================================");
			System.err.println("   => " + link1);
			System.err.println("   => " + link2);
			
			System.err.println("Utiliser les liens ci-dessous pour afficher tous les contrats de Web-Services :");
			System.err.println("   => " + link1 + "?wsdl");
			System.err.println("   => " + link2 + "?wsdl");

		} catch (Exception e) {
			System.err.println("ERROR : WebServices non publiés !");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
