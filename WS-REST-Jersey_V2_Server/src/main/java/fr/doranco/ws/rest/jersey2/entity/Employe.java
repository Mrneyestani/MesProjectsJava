package fr.doranco.ws.rest.jersey2.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employe")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employe implements Serializable {

	private static final long serialVersionUID = 2758169351644901292L;

	@XmlElement
	private Integer id;

	@XmlElement
	private String nom;

	@XmlElement
	private String prenom;

	@XmlElement
	private String posteOccupe;

	@XmlElement
	private String email;

	public Employe() {
	}

	public Employe(String nom, String prenom, String posteOccupe) {
		this.nom = nom;
		this.prenom = prenom;
		this.posteOccupe = posteOccupe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPosteOccupe() {
		return posteOccupe;
	}

	public void setPosteOccupe(String posteOccupe) {
		this.posteOccupe = posteOccupe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", posteOccupe=" + posteOccupe + ", email="
				+ email + "]";
	}

}
