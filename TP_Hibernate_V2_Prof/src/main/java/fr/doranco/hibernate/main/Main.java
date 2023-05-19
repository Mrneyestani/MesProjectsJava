package fr.doranco.hibernate.main;

import fr.doranco.hibernate.entity.Adresse;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.dao.impl.UserDao;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;
import fr.doranco.hibernate.utils.Dates;

public class Main {

	public static void main(String[] args) {

		IUserDao userDao = new UserDao();
		
		try {
			Adresse adresse = new Adresse("12", "Rue Paul Vaillant Couturier", "Paris", "75000");

			User user = new User();
			user.setNom("BLAISE");
			user.setPrenom("Pascal");
			user.setEmail("blaise@gmail.com");
			user.setPassword("blaisepascal");
			user.setDateNaissance(Dates.convertStringToDate("25/05/1950"));
			user.setAdresse(adresse);
			
			userDao.addUser(user);
			System.out.println(user);
			
//			int id = user.getId();
			
//			User userToUpdate = userDao.getUserById(id);
//			userToUpdate.setNom(userToUpdate.getNom() + "-MAJ");
//			userToUpdate.setPrenom(userToUpdate.getPrenom() + "-MAJ");
//			userDao.updateUser(userToUpdate);
//			User updatedUser = userDao.getUserById(id);
//			System.out.println(updatedUser);
//			int id = 1;
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
