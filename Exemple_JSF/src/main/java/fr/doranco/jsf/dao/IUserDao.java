package fr.doranco.jsf.dao;

import java.util.List;

import fr.doranco.jsf.entity.User;

public interface IUserDao {

	User addUser(User user) throws Exception;
	User getUserById(int id) throws Exception;
//	void updateUser(User user) throws Exception;
//	void deleteUser(int id) throws Exception;
	List<User> getUsers() throws Exception;
}


