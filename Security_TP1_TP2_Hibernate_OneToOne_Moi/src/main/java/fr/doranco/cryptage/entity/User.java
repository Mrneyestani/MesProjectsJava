package fr.doranco.cryptage.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
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

	@NotEmpty
	@Column(name = "email", unique = true, length = 30, nullable = false)
	private String email;

	@NotEmpty
	@Column(name = "pasword", length = 30, nullable = false)
	@Size(min = 8, max = 30)
	private byte[] password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carte_id", nullable = false)
	private CartePaiementCrypte cartePaiementCrypte;
	
	public User() {
		
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

	

	public CartePaiementCrypte getCartePaiementCrypte() {
		return cartePaiementCrypte;
	}

	public void setCartePaiementCrypte(CartePaiementCrypte cartePaiementCrypte) {
		this.cartePaiementCrypte = cartePaiementCrypte;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password_Byte=" + password + "]";
	}

}
