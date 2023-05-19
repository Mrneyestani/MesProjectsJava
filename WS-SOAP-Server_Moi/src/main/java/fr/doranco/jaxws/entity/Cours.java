package fr.doranco.jaxws.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cours", propOrder = {
		"id",
		"titre",
		"duree"
})
public class Cours {

	@XmlElement
	private Integer id;
	
	@XmlElement
	private String titre;
	
	@XmlElement
	private Integer duree; // en minutes

	public Cours() {
	}

	public Cours(String titre, Integer duree) {
		this.titre = titre;
		this.duree = duree;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		return "Cours [id=" + id + ", titre=" + titre + ", duree=" + duree + "]";
	}
	
	
}
