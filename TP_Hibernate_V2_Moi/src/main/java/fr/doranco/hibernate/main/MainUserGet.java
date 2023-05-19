package fr.doranco.hibernate.main;

import java.util.List;
import java.util.Map;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.dao.UserDao;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;

public class MainUserGet {

		public static void main(String[] args) {

			IUserDao userDao = new UserDao();
			
			try {
				List<User> users = userDao.getUsers();
				for (User user : users) {
					System.out.println(user);
					System.out.println("  -> " + user.getAdresse());
				}
				
				System.out.println("==========================================");
				
				User user = userDao.getUserByEmail("nafiseh@gmail.com");
				System.out.println(user);
				System.out.println("   -> " + user.getAdresse());

				System.out.println("==========================================");
				
				List<User> users2 = userDao.getUsersOfVille("Lyon");
				for (User user2 : users2) {
					System.out.println(user2);
					System.out.println("  -> " + user2.getAdresse());
				}

				System.out.println("==========================================");
				
				Map<String, List<User>> map = userDao.getUsersByVille();
				for (Map.Entry<String, List<User>> entry : map.entrySet()) {
					String ville = entry.getKey();
					System.out.println("Ville : " + ville);
					List<User> users3 = entry.getValue();
					for (User user3 : users3) {
						System.out.println("  => " + user3);
						System.out.println("     -> " + user3.getAdresse());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
