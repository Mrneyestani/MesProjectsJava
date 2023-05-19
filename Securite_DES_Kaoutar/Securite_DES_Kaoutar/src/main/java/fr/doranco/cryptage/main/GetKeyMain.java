package fr.doranco.cryptage.main;


import javax.crypto.SecretKey;

import fr.doranco.cryptage.algo.CipherCryptage;
import fr.doranco.cryptage.dao.ParamDao;
import fr.doranco.cryptage.entity.Param;


public class GetKeyMain {

	public static void main(String[] args) {
		ParamDao paramDao = new ParamDao();
		Param paramKeyByte = new Param();
		String test = "testtest";
		String numeroCarte = "67980934578";
		try {
			paramKeyByte = paramDao.getParamById(1);
			System.out.println(paramKeyByte);
			paramKeyByte.getCleByte();
			System.out.println("Key Byte : " + paramKeyByte.getCleByte());
			
			SecretKey cle =paramKeyByte.getCleSecretKey();
			
			System.out.println("test1 paramKeyByte :  " + paramKeyByte.getCleByte());
			System.out.println("test2 SCRETKeyByte : " +paramKeyByte.getCleSecretKey());
			
			
			
			byte[] encNumeroCarte = CipherCryptage.encrypterDES(numeroCarte, cle);
		      System.out.println("Numero Carte encrypte: " + new String(encNumeroCarte));
		      
		      String decNumeroCarte = CipherCryptage.decrypterDES(encNumeroCarte, cle);
		      System.out.println("Numero Carte decrypte : " + decNumeroCarte);
			

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
