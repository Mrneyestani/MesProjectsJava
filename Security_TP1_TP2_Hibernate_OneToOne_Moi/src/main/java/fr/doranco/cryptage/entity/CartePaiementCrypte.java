package fr.doranco.cryptage.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.doranco.cryptage.utils.AdaptorDate;

@Entity
@Table(name = "carte_paiement")
public class CartePaiementCrypte {

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

		
		
		
//		public CartePaiementCrypte(CartePaiement cartePaiement, SecretKey securityKey) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
//		
//			this.setId(cartePaiement.getId());
//			this.setDateValidite(cartePaiement.getDateValidite());
//			this.setNumeroCarte(CryptageDES.encrypterDES(cartePaiement.getNumeroCarte(), securityKey ));
//			this.setCryptogramme(CryptageDES.encrypterDES(cartePaiement.getCryptogramme(), securityKey ));
//		}

		public CartePaiementCrypte(byte[] numeroCarte, Date dateValidite, byte[] cryptogramme) {
		
			this.numeroCarte = numeroCarte;
			this.dateValidite = dateValidite;
			this.cryptogramme = cryptogramme;
		}

		public CartePaiementCrypte() {
			
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

		@Override
		public String toString() {
			return "CartePaiementCrypte [id=" + id + ", numeroCarte=" + Arrays.toString(numeroCarte) + ", dateValidite="
					+ dateValidite + ", cryptogramme=" + Arrays.toString(cryptogramme) + "]";
		}
		
	
}
