package fr.doranco.users.main;

import java.util.List;
import java.util.Set;

import fr.doranco.users.entity.Adresse;
import fr.doranco.users.entity.User;
import fr.doranco.users.metier.UserMetier;

public class Main {

	public static void main(String[] args) {
	
		User user1 = new User();
		user1.setNom("BLAISE");
		user1.setEmail("blaise@gmail.com");
		
		Adresse a1 = new Adresse("12", "Rue Lafayette", "Paris", "75001");
		Adresse a2 = new Adresse("7", "Bd de France", "Lyon", "69002");
		Adresse a3 = new Adresse("3Bis", "Passage de la gare", "Paris", "75005");
		
		user1.getAdresses().add(a1);
		user1.getAdresses().add(a2);
		user1.getAdresses().add(a3);
		
		User user2 = new User();
		user2.setNom("HUGO");
		user2.setEmail("hugo@gmail.com");
		
		a1 = new Adresse("32", "Rue Henri Dunant", "Paris", "75020");
		a2 = new Adresse("1", "Av de France", "Marseille", "13004");
		a3 = new Adresse("8", "Passage de la seine", "Lille", "59003");
		
		user2.getAdresses().add(a1);
		user2.getAdresses().add(a2);
		user2.getAdresses().add(a3);
		
		UserMetier.addUser(user1);
		UserMetier.addUser(user2);
		
		String email = "blaise@gmail.com";
		User user = UserMetier.getUserByEmail(email);
		if (user == null) {
			System.out.println("Aucun user ne correspond à l'adresse : " + email);
		} else {
			System.out.println(user);
		}
//		(user == null) ? System.out.println("Aucun user ne correspond à l'adresse : " + email);
//						: System.out.println(user);
		
		System.out.println("===============================================================");
		
		String city = "Paris";
		Set<User> users = UserMetier.getUsersOfCity(city);
		if (!users.isEmpty()) {
			for (User u : users) {
				System.out.println(u);
			}
		} else {
			System.out.println("Il n'existe aucun user habitant la ville de : " + city);
		}
		
	}

}
