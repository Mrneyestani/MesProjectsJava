package fr.doranco.monprojet.cryptage.keys;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public final class GenerateKeys {

	private GenerateKeys() {
	}

	public final static KeyPair getKeySignature(String algorithm, int keysize) throws Exception {
		
		if (algorithm == null || algorithm.isEmpty()) {
			throw new IllegalArgumentException("Il faut préciser l'algorithme !");
		}
		switch (algorithm) {
			case "DSA":
				// keysize must be a multiple of 64, ranging from 512 to 1024 (inclusive), 2048, or 3072.
				if (keysize == 2048 || keysize == 3072 || (keysize%64 == 0 && keysize >= 512 && keysize <= 1024)) {
					
					KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(algorithm);
					keyPairGen.initialize(keysize, new SecureRandom());
					return keyPairGen.generateKeyPair();
				} else {
					throw new IllegalArgumentException("keysize must be a multiple of 64, ranging from 512 to 1024 (inclusive), 2048, or 3072.");
				}
			case "RSA":
				throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas encore implémenté !");
			default:
				throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas pris en charge !");
		}
		
	}
	
	public final static SecretKey getKeyCryptage(String algorithm, Integer keysize) throws Exception {

		if (algorithm == null || algorithm.isEmpty()) {
			throw new IllegalArgumentException("Il faut préciser l'algorithme !");
		}
		if (keysize == null || keysize <= 0 || keysize%8 != 0) {
			throw new IllegalArgumentException("Le keysize est incorrect !");
		}
		SecretKey key = null;
		KeyGenerator keyGen = null;

		switch (algorithm) {
			case "DES":
				if (keysize != 56) {
					throw new IllegalArgumentException("Wrong keysize: must be equal to 56");
				}
				keyGen = KeyGenerator.getInstance(algorithm);
				keyGen.init(keysize);
				key = keyGen.generateKey();
				break;
			case "AES":
				List<Integer> listeKeySize = Arrays.asList(128, 192, 256);
				if (!listeKeySize.contains(keysize)) {
					throw new IllegalArgumentException("Wrong keysize: must be equal to 128, 192 or 256");
				}
				throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas encore implémenté !");
			default:
				throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas pris en charge !");
		}
		return key;
	}
}
