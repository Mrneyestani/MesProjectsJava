package fr.doranco.hibernate.main;

import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;

import fr.doranco.hibernate.algo.CipherCryptage;
import fr.doranco.hibernate.entity.Adresse;
import fr.doranco.hibernate.entity.CartePaiment;
import fr.doranco.hibernate.entity.Param;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.keys.KeyGenerateClasse;
import fr.doranco.hibernate.model.dao.impl.CartePaiementDao;
import fr.doranco.hibernate.model.dao.impl.ParamDao;
import fr.doranco.hibernate.model.dao.impl.UserDao;
import fr.doranco.hibernate.model.dao.interfaces.ICartePaiementDao;
import fr.doranco.hibernate.model.dao.interfaces.IParamDao;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;
import fr.doranco.hibernate.utils.AdaptorDate;



public class MainAdd {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		IUserDao userDao = new UserDao();
		IParamDao paramDao = new ParamDao();
		
		
		try {
			SecretKey securityKey1 = KeyGenerateClasse.generateKey("DES", 56); 
			SecretKey securityKey2 = KeyGenerateClasse.generateKey("Blowfish", 128); 
			
			CartePaiment cartePaiementCrypte1 = new CartePaiment(CipherCryptage.encrypterDES("5587968465398745","DES",securityKey1),
					AdaptorDate.convertDateStringToDateUtil("20/05/2025"),
					CipherCryptage.encrypterDES("325","DES",securityKey1));
			
			CartePaiment cartePaiementCrypte2 = new CartePaiment(CipherCryptage.encrypterDES("6587986541236589","DES",securityKey1),
					AdaptorDate.convertDateStringToDateUtil("15/02/2024"),
					CipherCryptage.encrypterDES("879","DES",securityKey1));
			
			
			
			CartePaiment cartePaiementCrypte3 = new CartePaiment();
			cartePaiementCrypte3.setNumeroCarte(CipherCryptage.encrypterDES("5859831145653656","Blowfish",securityKey2));
			cartePaiementCrypte3.setDateValidite(AdaptorDate.convertDateStringToDateUtil("25/12/2024"));
			cartePaiementCrypte3.setCryptogramme(CipherCryptage.encrypterDES("568","Blowfish",securityKey2));
			
			
			User user1 = new User();
			user1.setNom("Karimi");
			user1.setPrenom("Hassan");
			user1.setEmail("karimi@gmail.com");
			user1.setPassword(CipherCryptage.encrypterDES("mrn354596","DES",securityKey1));
			
			cartePaiementCrypte1.setUser(user1);
			cartePaiementCrypte2.setUser(user1);
			
			user1.getCartesPaiemants().add(cartePaiementCrypte1);
			user1.getCartesPaiemants().add(cartePaiementCrypte2);
			
		
			User user2 = new User();
			user2.setNom("Jafari");
			user2.setPrenom("Ehsan");
			user2.setEmail("jafari@gmail.com");
			user2.setPassword(CipherCryptage.encrypterDES("Ehsan56487","Blowfish",securityKey2));
			cartePaiementCrypte3.setUser(user2);
			user2.getCartesPaiemants().add(cartePaiementCrypte3);
			
			Param cle1 = new Param();
			cle1.setCleByte(securityKey1.getEncoded());
			cle1.setAlgoritm("DES");
			paramDao.addSecurityKey(cle1);
			userDao.addUser(user1);
			
			Param cle2 = new Param();
			cle2.setCleByte(securityKey2.getEncoded());
			cle2.setAlgoritm("Blowfish");
			paramDao.addSecurityKey(cle2);
			userDao.addUser(user2);
			
			System.out.println(user1);
			user1.getCartesPaiemants().forEach(cp -> System.out.println("  -> " + cp));
			
			System.out.println(user2);
			user2.getCartesPaiemants().forEach(cp -> System.out.println("  -> " + cp));
			//System.out.println("CartePaiement : " +cartePaiementCrypte1);
			System.out.println("SecurityKey généré : " +securityKey1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
