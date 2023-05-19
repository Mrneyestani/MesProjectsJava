package fr.doranco.ws.rest.jersey.resources;

import java.util.List;

import javax.ws.rs.core.UriBuilderException;

import fr.doranco.ws.rest.jersey.entity.Employe;

public interface IEmployeWebResource {

	String getInfos() throws UriBuilderException;
	String getEmployeXML(Integer id) throws UriBuilderException;
	String getEmployeJSON(Integer id) throws UriBuilderException;
	Employe getEmploye(Integer id) throws UriBuilderException;
	List<Employe> getEmployes() throws UriBuilderException;
	String addEmploye(Employe employe) throws UriBuilderException;
	String updateEmploye(Employe employe) throws UriBuilderException;
	String removeEmploye(Integer id) throws UriBuilderException;
}
