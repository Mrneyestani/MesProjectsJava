package fr.doranco.hibernate.main;

import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.dao.UserDao;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;
import fr.doranco.hibernate.utils.Dates;

public class MainUserDesactive {


	public static void main(String[] args) {
		
		try {
			int id = 1;
			IUserDao userDao = new UserDao();
			User user = userDao.getUserById(id);
			user.setIsActive(false);
				
			userDao.updateUser(user);
			System.out.println("User_"+id+" est désactivé avec succès");
			System.out.println(user);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.exit(0);
	}

}
