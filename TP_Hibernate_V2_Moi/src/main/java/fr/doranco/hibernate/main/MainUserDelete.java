package fr.doranco.hibernate.main;

import fr.doranco.hibernate.model.dao.UserDao;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;

public class MainUserDelete {


	public static void main(String[] args) {
		
		try {
			int id = 4;
			IUserDao userDao = new UserDao(); //cette methode suprime par Id
			userDao.deleteUser(id);
//			userDao.deleteUser(userDao.getUserById(id)); //cette methode suprime par user 
			System.out.println("User_"+id+" est suprimé avec succès");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.exit(0);
	}

}
