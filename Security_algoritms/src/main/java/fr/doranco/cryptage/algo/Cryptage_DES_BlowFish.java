package fr.doranco.cryptage.algo;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public final class Cryptage_DES_BlowFish {

	public final static SecretKey generate_Key(String algorithm, int keysize) throws Exception {

		KeyGenerator keyGen = null;
		keyGen = KeyGenerator.getInstance(algorithm);
		keyGen.init(keysize);
		
		return keyGen.generateKey();
	}

	public final static byte[] encrypter(String messageToEncrypt, String algoritm, SecretKey securityKey)
			throws Exception {

		Cipher cipher = Cipher.getInstance(algoritm);
		cipher.init(Cipher.ENCRYPT_MODE, securityKey);
		byte[] messageInBytes = messageToEncrypt.getBytes("UTF8");
		byte[] cipherBytes = cipher.doFinal(messageInBytes);

		return cipherBytes;
	}

	public final static String decrypter(byte[] messageToDecrypt, String algoritm, SecretKey securityKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance(algoritm);
		cipher.init(Cipher.DECRYPT_MODE, securityKey);
		byte[] messageDecrypte = cipher.doFinal(messageToDecrypt);
		String originalMessage = new String(messageDecrypte, "UTF8");
		return originalMessage;
	}

}
