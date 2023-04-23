package fr.doranco.exemple.main.user;

import fr.doranco.exemple.entity.User;
import fr.doranco.exemple.model.dao.IUserDao;
import fr.doranco.exemple.model.dao.UserDao;
import fr.doranco.exemple.utils.Dates;

public class MainUpdate {

	public static void main(String[] args) {

		try {
			IUserDao userDao = new UserDao();
			User user = userDao.getUserById(2);
			user.setNom("HUGO");
			user.setPrenom("Victor");
			user.setDateNaissance(Dates.convertStringToDate("21/03/1956"));
			userDao.updateUser(user);
			System.out.println("Mise à jour réussie");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
