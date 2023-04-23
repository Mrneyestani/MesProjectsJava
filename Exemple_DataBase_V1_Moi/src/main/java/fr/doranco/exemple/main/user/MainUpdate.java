package fr.doranco.exemple.main.user;

import fr.doranco.exemple.entity.User;
import fr.doranco.exemple.model.dao.IUserDao;
import fr.doranco.exemple.model.dao.UserDao;
import fr.doranco.exemple.utils.Dates;

public class MainUpdate {

	public static void main(String[] args) {

		try {
			IUserDao userDao = new UserDao();
			User user = userDao.getUserById(6);
			user.setNom("MOUTON");
			user.setPrenom("Michel");
			user.setDateNaissance(Dates.convertStringToDate("09/08/1978"));
			userDao.updateUser(user);
			System.out.println("Mise à jour réussie");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
