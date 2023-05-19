package fr.doranco.hibernate.main;

import fr.doranco.hibernate.entity.Adresse;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.dao.UserDao;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;
import fr.doranco.hibernate.utils.Dates;

public class MainUserAdd {


	public static void main(String[] args) {
		
		try {
			User user1 = new User("Neyestani", "Mohammadreza", Dates.convertStringToDate("09/08/1980"),"mohammadreza@mail.com", "655742552","mrn", true);
			Adresse adresse1 = new Adresse(50, "rue des landes", "Chatou", "78400");
			
//			User user2 = new User("Neyestani", "Zahra", Dates.convertStringToDate("01/07/2003"),"zahra@mail.com", "44444","zahra", true);
//			Adresse adresse2 = new Adresse(50, "rue des landes", "Chatou", "78400");
//			
//			User user3 = new User("Neyestani", "Fatemeh", Dates.convertStringToDate("20/08/2017"), "fatemeh@mail.com", "6687425","fatemeh", true);
//			Adresse adresse3 = new Adresse(50, "rue des landes", "Chatou", "78400");
//			
			IUserDao userDao = new UserDao();
			user1.setAdresse(adresse1);
			userDao.addUser(user1);
			System.out.println("User_1 est créé avec succès");
			System.out.println(user1);
			System.out.println(user1.getAdresse());
			
//			user2.setAdresse(adresse2);
//			userDao.addUser(user2);
//			
//			System.out.println(user2);
//			System.out.println(user2.getAdresse());
//			
//			user3.setAdresse(adresse3);
//			userDao.addUser(user3);
//			
//			System.out.println(user3);
//			System.out.println(user3.getAdresse());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.exit(0);
	}

}
