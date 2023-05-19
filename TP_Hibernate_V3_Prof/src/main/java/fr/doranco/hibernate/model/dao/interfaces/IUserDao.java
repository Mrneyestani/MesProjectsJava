package fr.doranco.hibernate.model.dao.interfaces;

import java.util.List;
import java.util.Map;

import fr.doranco.hibernate.entity.User;

public interface IUserDao {

	void addUser(User user) throws Exception;
	User getUserById(Integer id) throws Exception;
	void updateUser(User user) throws Exception;
	void deleteUser(User user) throws Exception;
	List<User> getUsers() throws Exception;
	User getUserByEmail(String email) throws Exception;
	List<User> getUsersOfVille(String ville) throws Exception;
	Map<String, List<User>> getUsersByVille() throws Exception;
}
