package fr.doranco.monprojet.main;

import java.security.Key;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import fr.doranco.monprojet.cryptage.algo.AlgorithmeCryptage;
import fr.doranco.monprojet.cryptage.keys.GenerateKeys;
import fr.doranco.monprojet.entity.CartePaiement;
import fr.doranco.monprojet.entity.User;
import fr.doranco.monprojet.enums.CryptageEnum;
import fr.doranco.monprojet.model.dao.IUserDao;
import fr.doranco.monprojet.model.dao.UserDao;
import fr.doranco.monprojet.utils.Dates;

public class MainCryptage {

	public static void main(String[] args) {

		try {
			User user = new User();
			user.setNom("BLAISE");
			user.setPrenom("Pascal");
			user.setEmail("blaise@gmail.com");
			String des = CryptageEnum.DES.getAlgorithme();
			SecretKey key = GenerateKeys.getKeyCryptage(des, 56);
			user.setPassword(AlgorithmeCryptage.encrypt("blaise123", key, des));
			user.setCleCryptage(key.getEncoded());
			
			CartePaiement cp = new CartePaiement();
			cp.setTitulaire("HUGO Victor");
			cp.setNumeroCarte(AlgorithmeCryptage.encrypt("1234567890123456", key, des));
			cp.setCryptogramme(AlgorithmeCryptage.encrypt("657", key, des));
			cp.setDateValidite(Dates.stringToDate("03/06/2024"));
			
			user.setCartePaiement(cp);
			
			IUserDao userDao = new UserDao();
			
			User addedUser = userDao.addUser(user);
			System.out.println(user);
			System.out.println("  => " + user.getCartePaiement());
			
			User u = userDao.getUserByEmail("blaise@gmail.com");
			
			System.out.println("==========================================");
			System.out.println("le user ajouté :");
			System.out.println(u);
			System.out.println("  => " + u.getCartePaiement());
			
			System.out.println("--------------------------------------------------");
			Key userKey = new SecretKeySpec(u.getCleCryptage(), 0, u.getCleCryptage().length, des);
			String mdpDecrypte = AlgorithmeCryptage.decrypt(u.getPassword(), userKey, des);
			System.out.println("-> mot de passe : " + mdpDecrypte);

			String numeroCarteDecrypte = AlgorithmeCryptage.decrypt(u.getCartePaiement().getNumeroCarte(), userKey, des);
			System.out.println("-> Numéro de la carte de paiement : " + numeroCarteDecrypte);

			String cryptoDecrypte = AlgorithmeCryptage.decrypt(u.getCartePaiement().getCryptogramme(), userKey, des);
			System.out.println("-> crypto de la carte de paiement : " + cryptoDecrypte);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
