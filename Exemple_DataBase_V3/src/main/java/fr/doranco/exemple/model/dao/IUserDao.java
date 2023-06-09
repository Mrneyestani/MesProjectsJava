package fr.doranco.exemple.model.dao;

import java.util.List;

import fr.doranco.exemple.entity.User;

public interface IUserDao {

	int addUser(User user) throws Exception;
	User getUserById(int id) throws Exception;
	void updateUser(User user) throws Exception;
	void deleteUser(int id) throws Exception;
	List<User> getUsers() throws Exception;
}


