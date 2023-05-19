package fr.doranco.jsf.vue.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.jsf.entity.Adresse;

@ManagedBean(name = "adressebean")
public class AdresseBean {

	@ManagedProperty(name = "numero", value = "30")
	private String numero;

	@ManagedProperty(name = "rue", value = "Rue la gloire")
	private String rue;

	@ManagedProperty(name = "codePostal", value = "70500")
	private String codePostal;

	@ManagedProperty(name = "ville", value = "paris")
	private String ville;

	private static List<Adresse> adresses = new ArrayList<Adresse>();

	public AdresseBean() {
	}

	public AdresseBean(String numero, String rue, String codePostal, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public void ajouterAdresse() {
		Adresse adresse = new Adresse(numero, rue, codePostal, ville);
		adresses.add(adresse);
		initialize();
	}

	private void initialize() {
		this.numero = "";
		this.rue = "";
		this.codePostal = "";
		this.ville = "";
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

}
