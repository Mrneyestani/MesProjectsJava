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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer id;

	@NotEmpty
	@Column(length = 20, nullable = false)
	private String numero;

	@NotNull
	@Column(name = "date_creation", nullable = false)
	private Date dateCreation;

	@NotNull
	@Column(name = "date_livraison", nullable = false)
	private Date DateLivraison;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
	private List<LigneCommande> lignesCommande;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	public Commande() {
		this.lignesCommande = new ArrayList<LigneCommande>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateLivraison() {
		return DateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		DateLivraison = dateLivraison;
	}

	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", dateCreation=" + dateCreation + ", DateLivraison="
				+ DateLivraison + "]";
	}

}
