package fr.doranco.cryptage.main;

import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;

import fr.doranco.cryptage.algo.Cryptage_DES_BlowFish;
import fr.doranco.cryptage.dao.impl.SecurityKeyDao;
import fr.doranco.cryptage.dao.impl.UserDao;
import fr.doranco.cryptage.dao.interfaces.ISecurityKey;
import fr.doranco.cryptage.dao.interfaces.IUserDao;
import fr.doranco.cryptage.entity.CartePaiementCrypte;
import fr.doranco.cryptage.entity.SecurityKey;
import fr.doranco.cryptage.entity.User;
import fr.doranco.cryptage.keys.GenerateKeys;
import fr.doranco.cryptage.utils.AdaptorDate;

public class MainAdd {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		IUserDao userDao = new UserDao();
		ISecurityKey securityKeyDao = new SecurityKeyDao();
		
		try {
			SecretKey securityKey1 = GenerateKeys.getKey("DES", 56); 
			SecretKey securityKey2 = GenerateKeys.getKey("Blowfish", 128); 
			
			CartePaiementCrypte cartePaiementCrypte1 = new CartePaiementCrypte(Cryptage_DES_BlowFish.encrypter("5587968465398745","DES",securityKey1),
					AdaptorDate.convertDateStringToDateUtil("20/05/2025"),
					Cryptage_DES_BlowFish.encrypter("325","DES",securityKey1));
			
			CartePaiementCrypte cartePaiementCrypte2 = new CartePaiementCrypte(Cryptage_DES_BlowFish.encrypter("6587986541236589","Blowfish",securityKey2),
					AdaptorDate.convertDateStringToDateUtil("15/02/2024"),
					Cryptage_DES_BlowFish.encrypter("879","Blowfish",securityKey2));
			
			CartePaiementCrypte cartePaiementCrypte3 = new CartePaiementCrypte();
			cartePaiementCrypte3.setNumeroCarte(Cryptage_DES_BlowFish.encrypter("5859831145653656","Blowfish",securityKey2));
			cartePaiementCrypte3.setDateValidite(AdaptorDate.convertDateStringToDateUtil("25/12/2024"));
			cartePaiementCrypte3.setCryptogramme(Cryptage_DES_BlowFish.encrypter("568","Blowfish",securityKey2));
			
			User user1 = new User();
			user1.setNom("Karimi");
			user1.setPrenom("Hassan");
			user1.setEmail("karimi@gmail.com");
			user1.setPassword(Cryptage_DES_BlowFish.encrypter("mrn354596","DES",securityKey1));
			user1.setCartePaiementCrypte(cartePaiementCrypte1);	
			
			User user2 = new User();
			user2.setNom("Jafari");
			user2.setPrenom("Ehsan");
			user2.setEmail("jafari@gmail.com");
			user2.setPassword(Cryptage_DES_BlowFish.encrypter("Ehsan56487","Blowfish",securityKey2));
			user2.setCartePaiementCrypte(cartePaiementCrypte3);	
			
			SecurityKey cle1 = new SecurityKey();
			cle1.setSecurityKey(securityKey1.getEncoded());
			cle1.setAlgoritm("DES");
			securityKeyDao.addSecurityKey(cle1);
			userDao.addUser(user1);
			
			SecurityKey cle2 = new SecurityKey();
			cle2.setSecurityKey(securityKey2.getEncoded());
			cle2.setAlgoritm("Blowfish");
			securityKeyDao.addSecurityKey(cle2);
			userDao.addUser(user2);
			
			System.out.println(user1);
			System.out.println(user2);
			
			System.out.println("CartePaiement : " +cartePaiementCrypte1);
			System.out.println("SecurityKey généré : " +securityKey1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
