package fr.doranco.cryptage.keys;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public final class GenerateKey {
	
	private GenerateKey() {
	}

	public final static SecretKey getKey(String algorithm, int keysize) throws Exception {

		KeyGenerator keyGen = null;
		
		switch (algorithm) {
			case "DES":
				keyGen = KeyGenerator.getInstance(algorithm);
				keyGen.init(keysize);
				break;
	
			default:
				break;
		}
		return keyGen.generateKey();
	}
}

