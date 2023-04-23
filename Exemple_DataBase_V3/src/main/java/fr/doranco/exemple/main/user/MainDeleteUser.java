package fr.doranco.exemple.main.user;

import fr.doranco.exemple.model.dao.IUserDao;
import fr.doranco.exemple.model.dao.UserDao;

public class MainDeleteUser {

	public static void main(String[] args) {

		try {
			IUserDao userDao = new UserDao();
			userDao.deleteUser(2);
			System.out.println("suppression de l'utilisateur réussie.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
