package fr.doranco.jaxws.soap.client.synchrone;

import java.util.List;

import fr.doranco.jaxws.soap.service.Cours;
import fr.doranco.jaxws.soap.service.CoursService;
import fr.doranco.jaxws.soap.service.CoursService_Service;

public class ClientCoursSynchrone {

	public static void main(String[] args) {

		try {
			CoursService_Service service = new CoursService_Service();
			CoursService ws = service.getCoursPort();

			List<Cours> cours = ws.getCours();
			cours.forEach(c -> System.out.println(c));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
