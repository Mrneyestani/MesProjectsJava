package fr.doranco.hibernate.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name = "User:findAll", query = "FROM User u"),
	@NamedQuery(name = "User:findByEmail", query = "FROM User u WHERE u.email = :email")
	})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotEmpty
	@Column(name = "nom", length = 30, nullable = false)
	private String nom;

	@NotEmpty
	@Column(name = "prenom", length = 30, nullable = false)
	private String prenom;

//	//@NotNull
//	@Column(name = "date_naissance", length = 30, nullable = false)
//	@Temporal(TemporalType.DATE)
//	private Date dateNaissance;

	@NotEmpty
	@Column(name = "email", unique = true, length = 30, nullable = false)
	private String email;

	@NotEmpty
	@Column(name = "pasword", length = 30, nullable = false)
	@Size(min = 8, max = 30)
	private byte[] password;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
//	private List<Adresse> adresses;
//
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//	private List<Commande> commandes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user" , fetch = FetchType.EAGER)
	private List<CartePaiment> CartesPaiemants;
	
	
	public User() {
		//this.adresses = new ArrayList<Adresse>();
		//this.commandes = new ArrayList<Commande>();
		this.CartesPaiemants = new ArrayList<CartePaiment>();
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

//	public Date getDateNaissance() {
//		return dateNaissance;
//	}
//
//	public void setDateNaissance(Date dateNaissance) {
//		this.dateNaissance = dateNaissance;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

//	public List<Adresse> getAdresses() {
//		return adresses;
//	}
//
//	public List<Commande> getCommandes() {
//		return commandes;
//	}
   
	public List<CartePaiment> getCartesPaiemants() {
		return CartesPaiemants;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom 
				+ ", email=" + email + ", password=" + password + "]";
	}

}
