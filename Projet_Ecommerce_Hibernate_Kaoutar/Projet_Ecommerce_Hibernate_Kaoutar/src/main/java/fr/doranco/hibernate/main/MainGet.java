package fr.doranco.hibernate.main;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import fr.doranco.hibernate.algo.CipherCryptage;
import fr.doranco.hibernate.entity.CartePaiment;
import fr.doranco.hibernate.entity.Param;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.dao.impl.ParamDao;
import fr.doranco.hibernate.model.dao.impl.UserDao;
import fr.doranco.hibernate.model.dao.interfaces.IParamDao;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;
import fr.doranco.hibernate.utils.AdaptorDate;



public class MainGet {

	public static void main(String[] args) {

		IUserDao userDao = new UserDao();
		IParamDao paramDao = new ParamDao();

		try {
						
			User user = userDao.getUserByEmail("jafari@gmail.com");
			Param param = paramDao.getSecurityKeyById(user.getId());
			byte[] keyBytes = param.getCleByte();
			String algoritm = param.getAlgoritm();
 			SecretKey Key = new SecretKeySpec(keyBytes, 0, keyBytes.length, algoritm);
			String password = CipherCryptage.decrypterDES(user.getPassword(),algoritm, Key);
			System.out.println("==========================================");
			System.out.println(user);
			System.out.println("Password en String : "+password);
			System.out.println("==========================================");
			for (CartePaiment cp : user.getCartesPaiemants()) {
				System.out.println("  -> " + cp);
				String cryptogramme = CipherCryptage.decrypterDES(cp.getCryptogramme(),algoritm, Key);
				String numeroCarte = CipherCryptage.decrypterDES(cp.getNumeroCarte(),algoritm, Key);
				System.out.println("CartePaiement [id=" + cp.getId() + ", numeroCarte=" + numeroCarte + ", dateValidite="
						+ AdaptorDate.convertDateUtilToDateString(cp.getDateValidite(), "MM/yy") + ", cryptogramme=" + cryptogramme + "]");
				//System.out.println("SecurityKey : "+securityKey);
				
			}
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
