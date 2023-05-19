package fr.doranco.hibernate.main;

import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.dao.UserDao;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;
import fr.doranco.hibernate.utils.Dates;

public class MainUserUpdate {


	public static void main(String[] args) {
		
		try {
			int id = 3;
			IUserDao userDao = new UserDao();
			User user = userDao.getUserById(id);
			user.setNom("Sayedghaleh");
			user.setPrenom("Nafiseh");
			user.setDateNaissance(Dates.convertStringToDate("15/12/1979"));
			user.setEmail("nafiseh@gmail.com");
			user.setPassword("666666");
			user.setLogin("nafiseh");
			user.setIsActive(true);
			
			user.getAdresse().setNomero(67);
			user.getAdresse().setRue("rue des landes");
			user.getAdresse().setVille("Chatou");
			user.getAdresse().setCodePostal("78400");
				
			userDao.updateUser(user);
			System.out.println("User_"+id+" est mise à jour avec succès");
			System.out.println(user);
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.exit(0);
	}

}
