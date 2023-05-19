package fr.doranco.hibernate.entity;


import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import fr.doranco.hibernate.keys.KeyGenerateClasse;



@Entity
@Table(name = "param")
public class Param {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty
	@Column(name = "algoritm", nullable = false)
	private String algoritm;
	
	@NotEmpty
	@Column(name = "cle", nullable = false)
	private byte[] cleByte;
	
	
	private SecretKey cleSecretKey;
	
	public Param() {
		
	}

	

	


	public byte[] getCleByte() {
		return cleByte;
	}






	public void setCleByte(byte[] cleByte) {
		this.cleByte = cleByte;
	}






	public SecretKey getCleSecretKey() {
		return cleSecretKey;
	}






	public void setCleSecretKey(SecretKey cleSecretKey) {
		this.cleSecretKey = cleSecretKey;
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

	public void convertCleSercetToCleBye() {	
		this.cleSecretKey =(KeyGenerateClasse.generateKey("DES", 56) );
	    this.cleByte = cleSecretKey.getEncoded();
	
	}
	
	public void convertCleByeToCleSercet() {
		//byte[] cleByte = convertCleSercetToCleBye();
		 this.cleSecretKey = new SecretKeySpec(this.cleByte, 0, this.cleByte.length, "DES");
		
		
	}
	
	
	@Override
	public String toString() {
		return "SecurityKey [id=" + id + ", algoritm=" + algoritm + ", securityKey=" + new String(cleByte)
				+ "]";
	}
	
	

}
