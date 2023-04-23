package fr.doranco.exemple.main.user;

import fr.doranco.exemple.entity.User;
import fr.doranco.exemple.model.dao.IUserDao;
import fr.doranco.exemple.model.dao.UserDao;
import fr.doranco.exemple.utils.Dates;

public class MainAdd {

	public static void main(String[] args) {

		try {
			final IUserDao userDao = new UserDao();

			User user = new User("Mouton", "Michel", Dates.convertStringToDate("21/04/1978"));
			int id = userDao.addUser(user);
			user.setId(id);
			System.out.println(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
