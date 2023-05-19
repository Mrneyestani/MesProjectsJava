package fr.doranco.cryptage.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "security_key")
public class SecurityKey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty
	@Column(name = "algoritm", nullable = false)
	private String algoritm;
	
	@NotEmpty
	@Column(name = "cle", nullable = false)
	private byte[] securityKey;
	
	
	public SecurityKey() {
		
	}


	public byte[] getSecurityKey() {
//		1 lire la base de donnees
//		SecretKey cle = SecurityKeyDao.get(1);
		
//		2 si la cle existe returner la cle
//		if (cle !=null) {
//			
//			return cle;
//		}
		
//		3 si non generer la cle
//		cle = genereCle();
		
//		4 enregistrer la cle dans bd
//		SecurityKeyDao.put(cle);
		
//		5 returner la cle
		
		return securityKey;
	}


	public void setSecurityKey(byte[] securityKey) {
		this.securityKey = securityKey;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAlgoritm() {
		return algoritm;
	}


	public void setAlgoritm(String algoritm) {
		this.algoritm = algoritm;
	}


	@Override
	public String toString() {
		return "SecurityKey [id=" + id + ", algoritm=" + algoritm + ", securityKey=" + new String(securityKey)
				+ "]";
	}
	
	

}
