package fr.doranco.hibernate.keys;

import java.security.Key;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import fr.doranco.hibernate.algo.CipherCryptage;

public class KeyGenerateClasse {
	
	public static SecretKey generateKey(String algorithm, int keysize) {
		KeyGenerator keyGen = null;
	    try {
	      keyGen = KeyGenerator.getInstance(algorithm);
	      keyGen.init(keysize);
	      SecretKey cle = keyGen.generateKey();
	      System.out.println("cle : " + new String(cle.getEncoded()));
	      return cle;

	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		return null;
	}

}
