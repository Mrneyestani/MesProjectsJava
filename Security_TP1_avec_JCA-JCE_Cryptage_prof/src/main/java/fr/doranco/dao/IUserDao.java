package fr.doranco.dao;

import fr.doranco.entity.pojo.User;

public interface IUserDao {
	
	User getUserByEmail(String email) throws Exception;
	User addUser(User user) throws Exception;
}
