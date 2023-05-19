package fr.doranco.jaxws.service;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebService;

import fr.doranco.jaxws.entity.Cours;

@WebService(endpointInterface = "fr.doranco.jaxws.service.CoursService", serviceName = "CoursService",
portName = "CoursPort")
public class CoursService implements ICoursService {

	@Override
	public Cours addCours(Cours cours) throws Exception {
		cours.setId(7);
		return cours;
	}

	@Override
	public Cours getCoursById(Integer id) throws Exception {
		Cours cours = new Cours("Cours de web service", 240);
		cours.setId(8);
		return cours;
	}

	@Override
	public List<Cours> getCours() throws Exception {
		Cours cours1 = new Cours("Cours de Java", 120);
		cours1.setId(3);
		Cours cours2 = new Cours("Cours de HTML", 60);
		cours2.setId(4);
		return Arrays.asList(cours1, cours2);
	}

}
