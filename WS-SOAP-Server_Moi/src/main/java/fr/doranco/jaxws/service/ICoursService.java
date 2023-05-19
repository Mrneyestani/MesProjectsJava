package fr.doranco.jaxws.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.doranco.jaxws.entity.Cours;

@WebService(name = "CoursService", targetNamespace = "http://service.jaxws.doranco.fr")
public interface ICoursService {

	@WebMethod
	Cours addCours(@WebParam(name = "cours") Cours cours) throws Exception;
	
	@WebMethod
	Cours getCoursById(@WebParam(name = "id") Integer id) throws Exception;
	
	@WebMethod
	List<Cours> getCours() throws Exception;
}
