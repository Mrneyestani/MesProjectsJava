package fr.doranco.cryptage.main;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import fr.doranco.cryptage.algo.Cryptage_DES_BlowFish;
import fr.doranco.cryptage.dao.impl.SecurityKeyDao;
import fr.doranco.cryptage.dao.impl.UserDao;
import fr.doranco.cryptage.dao.interfaces.ISecurityKey;
import fr.doranco.cryptage.dao.interfaces.IUserDao;
import fr.doranco.cryptage.entity.CartePaiementCrypte;
import fr.doranco.cryptage.entity.SecurityKey;
import fr.doranco.cryptage.entity.User;
import fr.doranco.cryptage.utils.AdaptorDate;

public class MainGet {

	public static void main(String[] args) {

		IUserDao userDao = new UserDao();
		ISecurityKey securityKeyDao = new SecurityKeyDao();

		try {
						
			User user = userDao.getUserByEmail("Rezayi@gmail.com");
			SecurityKey securityKey = securityKeyDao.getSecurityKeyById(user.getId());
			byte[] keyBytes = securityKey.getSecurityKey();
			String algoritm = securityKey.getAlgoritm();
 			SecretKey Key = new SecretKeySpec(keyBytes, 0, keyBytes.length, algoritm);
			String password = Cryptage_DES_BlowFish.decrypter(user.getPassword(),algoritm, Key);
			System.out.println("==========================================");
			System.out.println(user);
			System.out.println("Password en String : "+password);
			System.out.println("==========================================");
			CartePaiementCrypte cartePaiement = user.getCartePaiementCrypte();
			String cryptogramme = Cryptage_DES_BlowFish.decrypter(cartePaiement.getCryptogramme(),algoritm, Key);
			String numeroCarte = Cryptage_DES_BlowFish.decrypter(cartePaiement.getNumeroCarte(),algoritm, Key);
			System.out.println("CartePaiement [id=" + cartePaiement.getId() + ", numeroCarte=" + numeroCarte + ", dateValidite="
					+ AdaptorDate.convertDateUtilToDateString(cartePaiement.getDateValidite(), "MM/yy") + ", cryptogramme=" + cryptogramme + "]");
			System.out.println("SecurityKey : "+securityKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
