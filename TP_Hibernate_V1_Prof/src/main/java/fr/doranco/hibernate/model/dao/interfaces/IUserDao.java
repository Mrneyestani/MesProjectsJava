package fr.doranco.hibernate.model.dao.interfaces;

import fr.doranco.hibernate.entity.User;

public interface IUserDao {

	void addUser(User user) throws Exception;
	User getUserById(Integer id) throws Exception;
	void updateUser(User user) throws Exception;
	void deleteUser(User user) throws Exception;
}
