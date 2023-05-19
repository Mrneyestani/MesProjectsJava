package fr.doranco.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "adresse")
@XmlRootElement
public class Adresse implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@NotNull
	@Column(name= "nomero", length = 4, nullable = false )
	private Integer nomero;
	@NotEmpty
	@Column(name= "rue", length = 45, nullable = false )
	private String rue;
	@NotEmpty
	@Column(name= "ville", nullable = false )
	private String ville;
	@NotEmpty
	@Column(name= "code_postal", nullable = false )
	private String codePostal;
	
	@OneToOne(mappedBy = "adresse")
	private User user;
	
	public Adresse() {
		
	}
	
	

	public Adresse(Integer nomero, String rue, String ville, String codePostal) {
		
		this.nomero = nomero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNomero() {
		return nomero;
	}

	public void setNomero(Integer nomero) {
		this.nomero = nomero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Adresse [id=" + id + ", nomero=" + nomero + ", rue=" + rue + ", ville=" + ville + ", codePostal="
				+ codePostal + "]";
	}

	

	
}

