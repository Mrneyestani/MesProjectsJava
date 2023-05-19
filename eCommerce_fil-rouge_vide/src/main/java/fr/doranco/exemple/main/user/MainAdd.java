package fr.doranco.exemple.main.user;

import fr.doranco.exemple.entity.User;
import fr.doranco.exemple.model.dao.IUserDao;
import fr.doranco.exemple.model.dao.UserDao;
import fr.doranco.exemple.utils.Dates;

public class MainAdd {

	public static void main(String[] args) {

		try {
			final IUserDao userDao = new UserDao();

			User user = new User("BLAISE", "Pascal", Dates.convertStringToDate("25/12/1960"));
			User addedUser = userDao.addUser(user);
			System.out.println(addedUser);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
