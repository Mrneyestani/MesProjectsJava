package fr.doranco.hibernate.main;

import java.util.List;
import java.util.Map;

import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.dao.impl.UserDao;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;

public class MainGet {

	public static void main(String[] args) {

		IUserDao userDao = new UserDao();
		
		try {
			List<User> users = userDao.getUsers();
			for (User user : users) {
				System.out.println(user);
				user.getAdresses().forEach(a -> System.out.println("  -> " + a));
			}
			
//			System.out.println("==========================================");
//			
//			User user = userDao.getUserByEmail("blaise@gmail.com");
//			System.out.println(user);
//			user.getAdresses().forEach(a -> System.out.println("  -> " + a));
//
//			System.out.println("==========================================");
//			
//			List<User> users2 = userDao.getUsersOfVille("Paris");
//			for (User user2 : users2) {
//				System.out.println(user2);
//				user2.getAdresses().forEach(a -> System.out.println("  -> " + a));
//			}
//
//			System.out.println("==========================================");
//			
//			Map<String, List<User>> map = userDao.getUsersByVille();
//			for (Map.Entry<String, List<User>> entry : map.entrySet()) {
//				String ville = entry.getKey();
//				System.out.println("Ville : " + ville);
//				List<User> users3 = entry.getValue();
//				for (User user3 : users3) {
//					System.out.println("  => " + user3);
//					user3.getAdresses().forEach(a -> System.out.println("  -> " + a));
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
