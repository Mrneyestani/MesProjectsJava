package fr.doranco.cryptage.entity;

import java.util.Arrays;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import fr.doranco.cryptage.keys.KeyGenerateClasse;

public class Param {
	
	private Integer id; 
	private  SecretKey cleSecretKey;
	private  byte[] cleByte;
	
	
	
	
	public Param() {
		convertCleSercetToCleBye();
		
	}
		
	
	public Param(byte[] cleByte) {
		this.cleByte = cleByte;
	}

	public void convertCleSercetToCleBye() {	
		this.cleSecretKey =(KeyGenerateClasse.generateKey());
	    this.cleByte = cleSecretKey.getEncoded();
	
	}
	
	public void convertCleByeToCleSercet() {
		//byte[] cleByte = convertCleSercetToCleBye();
		 this.cleSecretKey = new SecretKeySpec(this.cleByte, 0, this.cleByte.length, "DES");
		
		
	}
	
	
	public SecretKey getCleSecretKey() {
		return cleSecretKey;
	}

	public void setCleSecretKey(SecretKey cleSecretKey) {
		this.cleSecretKey = cleSecretKey;
	}

	public  byte[] getCleByte() {
		return cleByte;
	}




	public void setCleByte( byte[] cleByte) {
		this.cleByte = cleByte;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Param [id=" + id + ", cleSecretKey=" + cleSecretKey + ", cleByte=" + Arrays.toString(cleByte) + "]";
	}
	

	



	
	
	
	

}