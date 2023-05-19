package fr.doranco.cryptage.main;


import javax.crypto.SecretKey;

import fr.doranco.cryptage.algo.CipherCryptage;
import fr.doranco.cryptage.dao.CartePaiementDao;
import fr.doranco.cryptage.dao.ICartePaiementDao;
import fr.doranco.cryptage.dao.IUserDao;
import fr.doranco.cryptage.dao.ParamDao;
import fr.doranco.cryptage.dao.UserDao;
import fr.doranco.cryptage.entity.CartePaiment;
import fr.doranco.cryptage.entity.Param;
import fr.doranco.cryptage.entity.User;
import fr.doranco.cryptage.keys.KeyGenerateClasse;
import fr.doranco.cryptage.utils.Dates;


//import fr.doranco.exemple.utils.Dates;


public class TestCryptageMain {

	public static void main(String[] args) {
		
		
		final String Password = "testtest";
		final String numeroCarte = "457897900789";
		final String cryptogramme = "7865";
		

	    //KeyGenerator keyGen;
	    try {
	    	
//	    SecretKey cle = KeyGenerateClasse.generateKey();
	    	
			
//			 byte[] encNumeroCarte = CipherCryptage.encrypterDES(numeroCarte, cle);
//		      System.out.println("Numero Carte encrypte: " + new String(encNumeroCarte));
//		      
//		      String decNumeroCarte = CipherCryptage.decrypterDES(encNumeroCarte, cle);
//		      System.out.println("Numero Carte decrypte : " + decNumeroCarte);
//		      
//		      byte[] encCryptogramme = CipherCryptage.encrypterDES(cryptogramme, cle);
//		      System.out.println("Cryptogramme encrypte : " + new String(encCryptogramme));
//		      
//		      String decCryptogramme = CipherCryptage.decrypterDES(encCryptogramme, cle);
//		      System.out.println("Cryptogramme decrypte : " + decCryptogramme);
//			

	     
//      ajouter la cle (les seux type Byte et secertKEY)
	      
	      ParamDao paramDao = new ParamDao();
			
			Param paramKeyByte = new Param();
//			ajouter USER
			
			paramKeyByte = paramDao.addParamKey(paramKeyByte);
			System.out.println(" secret key: " + paramKeyByte.getCleSecretKey());
			SecretKey cle =paramKeyByte.getCleSecretKey();
	      
			 byte[] encPassword = CipherCryptage.encrypterDES(Password, cle);
		      System.out.println("password encrypte : " + new String(encPassword));
		      
		      String decPassword = CipherCryptage.decrypterDES(encPassword, cle);
		      System.out.println("password decrypte : " + decPassword);
		      
		      byte[] encNumeroCarte = CipherCryptage.encrypterDES(numeroCarte, cle);
		      System.out.println("Numero Carte encrypte: " + new String(encNumeroCarte));
		      
		      String decNumeroCarte = CipherCryptage.decrypterDES(encNumeroCarte, cle);
		      System.out.println("Numero Carte decrypte : " + decNumeroCarte);
		      
		      byte[] encCryptogramme = CipherCryptage.encrypterDES(cryptogramme, cle);
		      System.out.println("Cryptogramme encrypte : " + new String(encCryptogramme));
		      
		      String decCryptogramme = CipherCryptage.decrypterDES(encCryptogramme, cle);
		      System.out.println("Cryptogramme decrypte : " + decCryptogramme);
			

		      
		 
		      
//	      final IUserDao userDao = new UserDao();
//			User user = new User("Israa", "NISSMA", "NISSMA@gmail.com",encPassword );
//			user = userDao.addUser(user);
//			System.out.println(user);
//			

	     
			//ajouter carte paiement
	      
//	      final ICartePaiementDao cartePaimentDao = new CartePaiementDao();
//			//CartePaiement cp1 = new CartePaiement("237566900877",  Dates.convertStringToDate("23/03/2024"), "421");
//			CartePaiment cp1 = new CartePaiment(encNumeroCarte, Dates.convertStringToDate("23/03/2024"), encCryptogramme);
//			cp1 = cartePaimentDao.addCartePaiement(cp1, 5);
//			cp1.setUserId(5);
//			System.out.println(cp1);
//	      
	      
	    
			
	      IUserDao userDao = new UserDao();
			User user = userDao.getUserById(5);
			user = userDao.getUserById(5);
			
			user.setPw(decPassword);
			
			System.out.println(user);
			
			for (CartePaiment cp : user.getCartesPaiment()) {
				cp.setCryptogrammeDecrypte(decCryptogramme);
				cp.setNumeroCarteDecrypte(decNumeroCarte);
				System.out.println("  -> " + cp);
			}
			

	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		
		
		
		 

	}

}
