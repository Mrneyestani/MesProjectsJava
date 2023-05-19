package fr.doranco.metier;

import fr.doranco.entity.dto.UserDto;
import fr.doranco.entity.pojo.User;

public interface IUserImpl {

	User getUserByEmail(String email) throws Exception;
	User addUser(UserDto userDto) throws Exception;
	User seLoguer(String email, String password) throws Exception;
}
