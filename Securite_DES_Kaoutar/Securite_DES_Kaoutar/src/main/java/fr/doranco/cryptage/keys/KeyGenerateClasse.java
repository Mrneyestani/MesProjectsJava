package fr.doranco.cryptage.keys;

import java.security.Key;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import fr.doranco.cryptage.algo.CipherCryptage;

public class KeyGenerateClasse {
	
	public static SecretKey generateKey() {
		KeyGenerator keyGen;
	    try {
	      keyGen = KeyGenerator.getInstance("DESede");
	      keyGen.init(168);
	      SecretKey cle = keyGen.generateKey();
	      System.out.println("cle : " + new String(cle.getEncoded()));
	      return cle;

	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		return null;
	}

}
