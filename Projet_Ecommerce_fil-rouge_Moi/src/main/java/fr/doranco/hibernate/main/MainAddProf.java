package fr.doranco.hibernate.main;

import javax.crypto.SecretKey;

import fr.doranco.hibernate.algo.CipherCryptage;
import fr.doranco.hibernate.entity.Adresse;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.keys.KeyGenerateClasse;
import fr.doranco.hibernate.model.dao.impl.UserDao;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;
import fr.doranco.hibernate.utils.Dates;

public class MainAddProf {

	public static void main(String[] args) {

		IUserDao userDao = new UserDao();
		
		try {
			
			SecretKey securityKey1 = KeyGenerateClasse.generateKey("DES", 56); 
			
			Adresse adresse1 = new Adresse("12", "Rue Paul Vaillant Couturier", "Paris", "75000");
			Adresse adresse2 = new Adresse("3", "Avenue Victor Hugo", "Lyon", "69000");

			User user = new User();
			user.setNom("BLAISE");
			user.setPrenom("Pascal");
			user.setEmail("blaise@gmail.com");
			//user.setPassword("blaisepascal");
			user.setPassword(CipherCryptage.encrypterDES("testtest","DES",securityKey1));
//			user.setDateNaissance(Dates.convertStringToDate("25/05/1950"));
//			
//			adresse1.setUser(user);
//			adresse2.setUser(user);
//			user.getAdresses().add(adresse1);
//			user.getAdresses().add(adresse2);
//			
//			userDao.addUser(user);
//			System.out.println(user);
//			user.getAdresses().forEach(a -> System.out.println("  -> " + a));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
