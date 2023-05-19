package fr.doranco.cryptage.main;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import fr.doranco.cryptage.algo.Cryptage_DES_BlowFish;
import fr.doranco.cryptage.dao.impl.SecurityKeyDao;
import fr.doranco.cryptage.dao.interfaces.ISecurityKey;
import fr.doranco.cryptage.keys.GenerateKeys;

public class Main_DES_BlowFish {

			public static void main(String[] args) throws Exception {
				ISecurityKey securityKeyDao = new SecurityKeyDao();
				final String message = "Bonjour! Je suis stagière en formation CDA, merci!";
				 
				  //Generate Key
					String algoritm = "Blowfish";
//					String algoritm = "DES";
				  SecretKey cle = GenerateKeys.getKey(algoritm, 56);//créér securityKey
			      System.out.println("cle (" + cle.getAlgorithm() + "," + cle.getFormat()
			          + ") : " + new String(cle.getEncoded()));
			      byte[] keyBytes = cle.getEncoded();//Méthode pour convertir securityKey to byte[]
//			      SecurityKey securityKey = securityKeyDao.getSecurityKeyById(1);//recuperer securityKey de datebase by id
//				  byte[] keyBytes = securityKey.getSecurityKey();//recuperer cle de security de datebase
			      SecretKey secretKey = new SecretKeySpec(keyBytes, 0, keyBytes.length, algoritm);//Méthode pour convertir securityKey de type byte[] to type secretKey
			      System.out.println("MessageOriginal : "+ message);
			      
			      //EnCryptage du message
			      System.out.println("Démarage du chiffrement...");
			      byte[] cipherBytes = Cryptage_DES_BlowFish.encrypter(message,algoritm, secretKey);
			      String messageCrypte = new String(cipherBytes, "UTF8");
			      System.out.println("MessageCrypte : "+ messageCrypte);
			      
			      //DeCryptage du message
			      String messageDesCrypte = Cryptage_DES_BlowFish.decrypter(cipherBytes,algoritm, secretKey);
			      System.out.println("MessageDesCrypte : "+messageDesCrypte); 
			   
			    }

	}


