package fr.doranco.monprojet.model.dao;

import fr.doranco.monprojet.entity.User;

public interface IUserDao {

	User addUser(User user) throws Exception;
	User getUserByEmail(String email) throws Exception;
}
