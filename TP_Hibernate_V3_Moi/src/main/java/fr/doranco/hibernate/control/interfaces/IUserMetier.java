package fr.doranco.hibernate.control.interfaces;

import java.util.List;
import fr.doranco.hibernate.entity.User;

public interface IUserMetier {

	void addUser(User user) throws Exception;
	void deleteUser(User user) throws Exception;
	List<User> getUsers() throws Exception;
}
