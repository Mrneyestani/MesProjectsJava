package fr.doranco.ws.rest.jersey2.server;

import java.util.ArrayList;
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
import javax.ws.rs.core.Response;

import fr.doranco.ws.rest.jersey2.entity.Employe;

@Path("/employes")
public class EmployeWebResource {

	private final static String CHARSET = ";charset=UTF-8";

	@GET
	public String getInfos() {
		return "Bonjour from Doranco.";
	}

	@GET
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response getEmployeById(@PathParam("id") Integer id) {

		if (id == null || id <= 0) {
			return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
					.entity("L'id de l'employé doit être > 0 !").header("Société", "DORANCO")
					.header("Adresse", "Gallieni").build();
		}
		Employe employe = new Employe("BLAISE", "Pascal", "Ecrivain");
		employe.setId(3);
		return Response.ok().entity(employe).build();
	}

	
	@GET
	@Path("email/{email}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response getEmployeByEmail(@PathParam("email") String email) {

		try {
			if (email == null || email.isEmpty()) {
				return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
						.header("error", "L'email de l'employé doit être renseigné !")
						.header("Société", "DORANCO")
						.header("Adresse", "Gallieni")
						.build();
			}
			Employe employe = new Employe("BLAISE", "Pascal", "Ecrivain");
			employe.setEmail("blaise@gmail.com");
			employe.setId(3);
			
			if (email.equals(employe.getEmail())) {			
				return Response.ok()
						.entity(employe)
						.build();
			} else {
				return Response.status(204)
						.header("error", "Il n'existe pas d'employé avec l'email donné.")
						.build();
			}

		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
					.header("error", "Erreur interne au serveur !\n" + e.getMessage())
					.build();
		}
	}

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response getEmployes() {

		try {
			Employe employe1 = new Employe("BLAISE", "Pascal", "Ecrivain");
			employe1.setId(5);
			Employe employe2 = new Employe("HUGO", "Victor", "Romancier");
			employe2.setId(6);
			
			List<Employe> employes = new ArrayList<Employe>();
			employes.add(employe1);
			employes.add(employe2);

			return Response.status(Response.Status.OK.getStatusCode())
					.entity(employes)
					.build();

		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
					.entity("Erreur interne au serveur !")
					.build();
		}
	}

	@POST
	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmploye(Employe employe) {

		try {
			if (employe == null) {
				return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
						.entity("L'objet employé ne doit pas être NULL !")
						.build();
			}
			if (employe.getNom() == null || employe.getNom().isEmpty()
					|| employe.getPrenom() == null || employe.getPrenom().isEmpty()
					|| employe.getPosteOccupe() == null || employe.getPosteOccupe().isEmpty()) {
				
				return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
						.entity("Tous les paramètres de 'employé' sont obligatoires !")
						.build();
			}
			int id = 7;
			employe.setId(id);
			return Response.status(Response.Status.CREATED.getStatusCode())
					.entity(id)
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
					.entity("Erreur interne au serveur !")
					.build();
			
		}
	}

	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response updateEmploye(Employe employe) {

		try {
			if (employe == null) {
				return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
						.header("error", "L'objet employé ne doit pas être NULL !")
						.build();
			}
			if (employe.getNom() == null || employe.getNom().isEmpty()
					|| employe.getPrenom() == null || employe.getPrenom().isEmpty()
					|| employe.getPosteOccupe() == null || employe.getPosteOccupe().isEmpty()) {
				
				return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
						.header("error", "Tous les paramètres de 'employé' sont obligatoires !")
						.build();
			}
			employe.setNom(employe.getNom() + "-MAJ");
			employe.setPrenom(employe.getPrenom() + "-MAJ");
			return Response.accepted()
					.entity(employe)
					.header("message", "Employé mis à jour avec succès")
					.build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
					.header("error", "Erreur interne au serveur !")
					.build();
			
		}
	}
	
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response deleteEmploye(@PathParam("id") Integer id) {

		try {
			if (id == null || id <= 0) {
				return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
						.header("error", "L'id de l'employé à supprimer doit être > 0 !")
						.build();
			}
			// 3 écritures équivalentes :
			//Response.status(Response.Status.ACCEPTED)
			//Response.status(202)
			//Response.accepted()
			 
			return Response.accepted()
					.header("message", "L'Employé avec l'id " + id + " a été supprimé.")
					.build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
					.header("error", "Erreur interne au serveur !")
					.build();
			
		}
	}
}
