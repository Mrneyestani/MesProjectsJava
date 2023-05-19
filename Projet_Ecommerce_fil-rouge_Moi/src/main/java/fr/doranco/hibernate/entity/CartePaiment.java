package fr.doranco.hibernate.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.doranco.hibernate.utils.AdaptorDate;

@Entity
@Table(name = "carte_paiement")
public class CartePaiment {
	

			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name = "id")
			private Integer id;
			
			@Column(name = "numero_carte", length = 16, nullable = false)
			private byte[] numeroCarte;
			
			@Column(name = "date_validite", nullable = false)
			private Date dateValidite;
			
			@Column(name = "cryptogramme", length = 3, nullable = false)
			private byte[] cryptogramme;
			
			@ManyToOne
			@JoinColumn(name = "user_id", nullable = false)
			private User user;
			

			public CartePaiment() {
			
			}

			public CartePaiment(byte[] numeroCarte, Date dateValidite, byte[] cryptogramme) {
				super();
				this.numeroCarte = numeroCarte;
				this.dateValidite = dateValidite;
				this.cryptogramme = cryptogramme;
			}

			public Integer getId() {
				return id;
			}
			
			public void setId(Integer id) {
				this.id = id;
			}

			public byte[] getNumeroCarte() {
				return numeroCarte;
			}

			public void setNumeroCarte(byte[] numeroCarte) {
				this.numeroCarte = numeroCarte;
			}

			public Date getDateValidite() {
				return dateValidite;
			}

			public void setDateValidite(Date dateValidite) {
				this.dateValidite = AdaptorDate.convertDateUtilToDateSql(dateValidite);
			}

			public byte[] getCryptogramme() {
				return cryptogramme;
			}
			

			public void setCryptogramme(byte[] cryptogramme) {
				this.cryptogramme = cryptogramme;
			}
			
			public User getUser() {
				return user;
			}

			public void setUser(User user) {
				this.user = user;
			}
			
			@Override
			public String toString() {
				return "CartePaiementCrypte [id=" + id + ", numeroCarte=" + Arrays.toString(numeroCarte) + ", dateValidite="
						+ dateValidite + ", cryptogramme=" + Arrays.toString(cryptogramme) + "]";
			}
			
	
}
