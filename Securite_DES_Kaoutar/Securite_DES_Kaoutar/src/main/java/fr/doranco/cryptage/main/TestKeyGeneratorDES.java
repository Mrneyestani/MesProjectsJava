package fr.doranco.cryptage.main;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import fr.doranco.cryptage.algo.CipherCryptage;
import fr.doranco.cryptage.keys.KeyGenerateClasse;

public class TestKeyGeneratorDES {

	public static void main(String[] args) {
//		KeyGenerator keyGen;
//	    try {
//	      keyGen = KeyGenerator.getInstance("DES");
//	      keyGen.init(new SecureRandom());
//	      SecretKey cle = keyGen.generateKey();
//	      System.out.println("cle (" + cle.getAlgorithm() + "," + cle.getFormat()
//	          + ") : " + new String(cle.getEncoded()));
//	      
//	      
//	     
//	    } catch (Exception e) {
//	      e.printStackTrace();
//	    }
		
		final String message = "{{ ---((Mon message a traiter %%%%";

	    //KeyGenerator keyGen;
	    try {
	    	
	    SecretKey cle = KeyGenerateClasse.generateKey();

	      byte[] enc = CipherCryptage.encrypterDES(message, cle);
	      System.out.println("texte encrypte : " + new String(enc));

	      String dec = CipherCryptage.decrypterDES(enc, cle);
	      System.out.println("texte decrypte : " + dec);

	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	}

}
