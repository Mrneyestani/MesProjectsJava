package fr.doranco.ws.rest.jersey.resources;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.doranco.ws.rest.jersey.entity.Employe;
import fr.doranco.ws.rest.jersey.utils.Transformation;

@Path("employes")
@Produces(MediaType.TEXT_PLAIN)
public class EmployeWebResource implements IEmployeWebResource {

	@Override
	@GET
	public String getInfos() {
		return "Bonjour de la part de Doranco";
	}

	@Override
	@GET
	@Path("xml/{identity}")
	public String getEmployeXML(@PathParam("identity") Integer id) {
		
		Employe employe = new Employe("HUGO", "Victor", "Ecrivain");
		employe.setId(id);
		return Transformation.fromEmployeToXML(employe);
	}

	@Override
	@GET
	@Path("json/{identity}")
	public String getEmployeJSON(@PathParam("identity") Integer id) {
		
		Employe employe = new Employe("HUGO", "Victor", "Ecrivain");
		employe.setId(id);
		return Transformation.fromEmployeToJSON(employe);
	}

	@Override
	@GET
	@Path("{identity}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Employe getEmploye(@PathParam("identity") Integer id) {
		
		Employe employe = new Employe("HUGO", "Victor", "Ecrivain");
		employe.setId(id);
		return employe;
	}

	@Override
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employe> getEmployes() {

		Employe employe1 = new Employe("HUGO", "Victor", "Ecrivain");
		employe1.setId(1);
		Employe employe2 = new Employe("CAMUS", "Albert", "Historien");
		employe2.setId(2);
		List<Employe> employes = Arrays.asList(employe1, employe2);
		return employes;
}

	@Override
	@POST
	@Path("create")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String addEmploye(Employe employe) {
		int id = 7;
		employe.setId(id);
		return String.valueOf(id);
	}

	@Override
	@PUT
	@Path("update")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String updateEmploye(Employe employe) {
		
		return "L'employé avec id = " + employe.getId() + " a été mis à jour avec succès.";
	}

	@Override
	@DELETE
	@Path("remove/{id}")
	public String removeEmploye(@PathParam("id") Integer id) {

		return "L'employé avec id = " + id + " a été supprimé avec succès.";
	}

}
