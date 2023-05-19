package fr.doranco.ws.rest.jersey.utils;

import org.json.JSONObject;

import fr.doranco.ws.rest.jersey.entity.Employe;

public final class Transformation {

	private Transformation() {
	}
	
	public static final String fromEmployeToXML(Employe employe) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
			.append("<employe>")
			.append("<id>").append(employe.getId()).append("</id>")
			.append("<nom>").append(employe.getNom()).append("</nom>")
			.append("<prenom>").append(employe.getPrenom()).append("</prenom>")
			.append("<posteOccupe>").append(employe.getPosteOccupe()).append("</posteOccupe>")
			.append("</employe>");
		
		return sb.toString();
	}
	
	public static final String fromEmployeToJSON(Employe employe) {
		
		JSONObject json = new JSONObject();
		json.put("id", employe.getId())
			.put("nom", employe.getNom())
			.put("prenom", employe.getPrenom())
			.put("posteOccupe", employe.getPosteOccupe());
		
		return json.toString();
	}

}
