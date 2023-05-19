package fr.doranco.jaxws.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.doranco.jaxws.entity.Etudiant;

@WebService(name = "EtudiantService", targetNamespace = "http://service.jaxws.doranco.fr")
public interface IEtudiantService {

	@WebMethod
	Etudiant addEtudiant(@WebParam(name = "etudiant") Etudiant etudiant) throws Exception;
	
	@WebMethod
	Etudiant getEtudiantById(@WebParam(name = "id") Integer id) throws Exception;
	
	@WebMethod
	List<Etudiant> getEtudiants() throws Exception;
	
}
