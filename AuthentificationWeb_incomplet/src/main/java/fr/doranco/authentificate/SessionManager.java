package fr.doranco.authentificate;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.doranco.entity.User;

@ManagedBean
@SessionScoped
public class SessionManager implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public String login(String username, String password) {
        UserManager userManager = new UserManager();
        User user = userManager.authenticate(username, password);

        if (user != null) {
            currentUser = user;
            return "dashboard.xhtml"; // Redirige vers la page de tableau de bord après une authentification réussie
        } else {
            // Affiche un message d'erreur ou effectue des actions supplémentaires en cas d'échec de l'authentification
            return ""; // Reste sur la même page (ou peut rediriger vers une page d'échec de connexion)
        }
    }

    public String logout() {
        currentUser = null;
        return "login.xhtml"; // Redirige vers la page de connexion après la déconnexion
    }
}
