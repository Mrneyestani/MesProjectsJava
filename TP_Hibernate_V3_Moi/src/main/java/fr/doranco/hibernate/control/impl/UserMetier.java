package fr.doranco.hibernate.control.impl;

import java.util.List;
import fr.doranco.hibernate.control.interfaces.IUserMetier;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.dao.UserDao;
import fr.doranco.hibernate.model.dao.interfaces.IUserDao;
import fr.doranco.hibernate.utils.Dates;

public class UserMetier implements IUserMetier {

	private final IUserDao userDao = new UserDao();
	
	@Override
	public void addUser(User user) throws Exception {
		if (user == null) {
			throw new NullPointerException("Le user à créer ne doit pas être null !");
		}
		user.setNom(user.getNom().toUpperCase());
		user.setPrenom(user.getPrenom().substring(0, 1).toUpperCase()
						.concat(user.getPrenom().substring(1).toLowerCase()));
		user.setDateNaissance(Dates.convertDateUtilToSql(user.getDateNaissance()));
		userDao.addUser(user);
	}

	@Override
	public List<User> getUsers() throws Exception {
		return userDao.getUsers();
	}

	@Override
	public void deleteUser(User user) throws Exception {
		userDao.deleteUser(user.getId());
		
	}

}
