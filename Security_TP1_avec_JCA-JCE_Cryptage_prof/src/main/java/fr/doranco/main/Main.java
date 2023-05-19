package fr.doranco.main;

import fr.doranco.entity.dto.CartePaiementDto;
import fr.doranco.entity.dto.UserDto;
import fr.doranco.entity.pojo.User;
import fr.doranco.metier.IUserImpl;
import fr.doranco.metier.UserImpl;

public class Main {

	public static void main(String[] args) {
		
		IUserImpl userImpl = new UserImpl();
		
		try {
			UserDto userDto = new UserDto("CAMUS", "Albert", "camus@gmail.com", "camus");
			CartePaiementDto cartePaiementDto = new CartePaiementDto("CAMUS Delphine", "1234567812345678", "123", "01/01/2023");
			userDto.setCartePaiementDto(cartePaiementDto);
			User user1 = userImpl.addUser(userDto);
			System.out.println(user1);
			
			UserDto userDto2 = new UserDto("HUGO", "Victor", "hugo@gmail.com", "hugo");
			CartePaiementDto cartePaiementDto2 = new CartePaiementDto("HUGO Victor", "8765432187654321", "321", "02/02/2024");
			userDto2.setCartePaiementDto(cartePaiementDto2);
			User user2 = userImpl.addUser(userDto2);
			System.out.println(user2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
