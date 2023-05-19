package fr.doranco.cryptage.algo;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;



public class CipherCryptage {
	
	 public static byte[] encrypterDES(final String message, SecretKey cle)
   	      throws NoSuchAlgorithmException, NoSuchPaddingException,
   	      InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
   	    Cipher cipher = Cipher.getInstance("DESede");
   	    cipher.init(Cipher.ENCRYPT_MODE, cle);
   	    byte[] donnees = message.getBytes();

   	    return cipher.doFinal(donnees);
   	  }

   	  public static String decrypterDES(final byte[] donnees, SecretKey cle)
   	      throws NoSuchAlgorithmException, NoSuchPaddingException,
   	      InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
   	    Cipher cipher = Cipher.getInstance("DESede");
   	    cipher.init(Cipher.DECRYPT_MODE, cle);

   	    return new String(cipher.doFinal(donnees));
   	  }

}
