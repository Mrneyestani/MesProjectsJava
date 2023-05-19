package fr.doranco.cryptage.dao.interfaces;

import fr.doranco.cryptage.entity.User;

public interface IUserDao {

	void addUser(User user) throws Exception;
	User getUserByEmail(String email) throws Exception;

}
