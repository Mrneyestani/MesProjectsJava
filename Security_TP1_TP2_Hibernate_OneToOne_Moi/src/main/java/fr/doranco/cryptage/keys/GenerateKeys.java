package fr.doranco.cryptage.keys;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public final class GenerateKeys {

	private GenerateKeys() {
	}

	public final static SecretKey getKey(String algorithm, int keysize) throws Exception {

		KeyGenerator keyGen = null;

		switch (algorithm) {
		case "DES":
			keyGen = KeyGenerator.getInstance(algorithm);
			keyGen.init(keysize);
			break;

		case "Blowfish":
			keyGen = KeyGenerator.getInstance(algorithm);
			keyGen.init(keysize);
			break;

		default:
			break;
		}
		return keyGen.generateKey();
	}
}