package fr.doranco.hibernate.algo;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;



public class CipherCryptage {
	
	 public static byte[] encrypterDES(final String message, String algoritm,SecretKey cle)
   	      throws NoSuchAlgorithmException, NoSuchPaddingException,
   	      InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
   	    Cipher cipher = Cipher.getInstance(algoritm);
   	    cipher.init(Cipher.ENCRYPT_MODE, cle);
   	    byte[] donnees = message.getBytes();

   	    return cipher.doFinal(donnees);
   	  }

   	  public static String decrypterDES(final byte[] donnees, String algoritm,SecretKey cle)
   	      throws NoSuchAlgorithmException, NoSuchPaddingException,
   	      InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
   	    Cipher cipher = Cipher.getInstance(algoritm);
   	    cipher.init(Cipher.DECRYPT_MODE, cle);

   	    return new String(cipher.doFinal(donnees));
   	  }

}
