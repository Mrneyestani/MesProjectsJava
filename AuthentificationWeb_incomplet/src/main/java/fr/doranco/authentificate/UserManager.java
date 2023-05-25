package fr.doranco.authentificate;

import fr.doranco.entity.User;

public class UserManager {
	
    public User authenticate(String username, String password) {
        // Effectuez une logique de vérification des informations d'identification ici
        // Par exemple, vous pouvez interroger une base de données pour récupérer les informations de l'utilisateur

        // Ici, nous utilisons un exemple statique avec des informations d'identification codées en dur
        if (username.equals("admin") && password.equals("password")) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            return user;
        }

        return null; // L'authentification a échoué
    }
}
