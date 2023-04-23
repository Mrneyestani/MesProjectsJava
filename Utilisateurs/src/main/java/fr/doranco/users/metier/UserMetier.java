package fr.doranco.users.metier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.doranco.users.entity.Adresse;
import fr.doranco.users.entity.User;

public abstract class UserMetier {

	private static List<User> users = new ArrayList<User>();
	
	public static User getUserByEmail(String email) {
		
		for (User u : users) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}
		return null;
	}
	
	public static Set<User> getUsersOfCity(String city) {
		
		Set<User> usersFound = new HashSet<User>();
		for (User u : users) {
			for (Adresse a : u.getAdresses()) {
				if (a.getVille().equals(city)) {
					usersFound.add(u);
				}
			}
		}
		return usersFound;
	}
	
	public static void addUser(User user) {
		users.add(user);
	}
	
}
