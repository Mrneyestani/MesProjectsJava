package fr.doranco.monprojet.cryptage.algo;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;

public final class AlgorithmeCryptage {

	private AlgorithmeCryptage() {
	}
	
	public final static byte[] encrypt(String messageToEncrypt, Key key, String algorithm) throws Exception {
		
			switch(algorithm) {
				case "DES" :
				case "AES" :
				case "BLOWFISH" :
					Cipher cipher = Cipher.getInstance(algorithm);
					cipher.init(Cipher.ENCRYPT_MODE, key);
					return cipher.doFinal(messageToEncrypt.getBytes("UTF-8"));
				case "PBE_MD5_DES" :
					throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas encore implémenté !");
				default :
					throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas pris en charge !");
		}
	}
	
	public final static String decrypt(byte[] messageCrypte, Key key, String algorithm) throws Exception {

		switch(algorithm) {
			case "DES" :
			case "AES" :
			case "BLOWFISH" :
				Cipher cipher = Cipher.getInstance(algorithm);
				cipher.init(Cipher.DECRYPT_MODE, key);
				byte[] messageDecrypteByte = cipher.doFinal(messageCrypte);
				return new String(messageDecrypteByte);
			case "PBE_MD5_DES" :
				throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas encore implémenté !");
			default :
				throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas pris en charge !");
		}
	}
}
