package fr.doranco.jsf.model.dao;

import java.util.List;

import fr.doranco.jsf.entity.User2;

public interface IUserDao {

	int addUser(User2 user) throws Exception;
	User2 getUserById(int id) throws Exception;
//	void updateUser(User user) throws Exception;
//	void deleteUser(int id) throws Exception;
	List<User2> getUsers() throws Exception;
}
