package fr.doranco.hibernate.main;

import javax.crypto.SecretKey;

import fr.doranco.hibernate.algo.CipherCryptage;
import fr.doranco.hibernate.entity.Adresse;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.keys.KeyGenerateClasse;
import fr.doranco.hibernate.model.dao.impl.UserDao;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;
import fr.doranco.hibernate.utils.Dates;

public class MainDelete {

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
//			user.getAdresses().add(adresse1);
//			user.getAdresses().add(adresse2);
			
			userDao.addUser(user);
			System.out.println(user);
			
//			int id = user.getId();
//			
//			User userToUpdate = userDao.getUserById(id);
//			userToUpdate.setNom(userToUpdate.getNom() + "-MAJ");
//			userToUpdate.setPrenom(userToUpdate.getPrenom() + "-MAJ");
//			userDao.updateUser(userToUpdate);
//			User updatedUser = userDao.getUserById(id);
//			System.out.println(updatedUser);
//			
//			User userToDelete = userDao.getUserById(id);
//			userDao.deleteUser(userToDelete);
//			User deletedUser = userDao.getUserById(id);
//			if (deletedUser == null) {
//				System.out.println("Le user avec l'id = " + id + " n'existe pas !");
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
