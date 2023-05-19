package fr.doranco.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "user")
@XmlRootElement

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
	@Column(name= "nom", length = 25, nullable = false )
	private String nom;
	
	@NotEmpty
	@Column(name= "prenom", length = 25, nullable = false )
	private String prenom;
	
	@NotEmpty
	@Column(name= "date_naissance", nullable = false )
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Column(name= "email", nullable = false )
	private String email;
	
	@NotEmpty
	@Column(name= "password", nullable = false )
	@Size(min = 8, max=30)
	private String password;
	
	@NotEmpty
	@Column(name= "login", nullable = false )
	private String login;
	
	@NotEmpty
	@Column(name= "is_active", nullable = false )
	private Boolean isActive;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adresse_id", nullable = false)
	private Adresse adresse;
	
	
	
	public User() {
		
	}


	public User(String nom, String prenom, Date dateNaissance, String email, String password, String login,
			Boolean isActive) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
		this.login = login;
		this.isActive = isActive;
	
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



	public Date getDateNaissance() {
		return dateNaissance;
	}



	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public Adresse getAdresse() {
		return adresse;
	}



	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", email=" + email + ", password=" + password + ", login=" + login + ", isActive=" + isActive
				+ ", adresse=" + adresse + "]";
	}

}
