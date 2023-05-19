package fr.doranco.utils;

import fr.doranco.cryptage.algo.CryptageDES;
import fr.doranco.entity.dto.CartePaiementDto;
import fr.doranco.entity.dto.UserDto;
import fr.doranco.entity.pojo.CartePaiement;
import fr.doranco.entity.pojo.User;

public final class PojoDto {
	
	private PojoDto() {
	}
	
	public final static Object convertFromPojoToDto(Object object) throws Exception {
		
		if (object == null) {
			throw new NullPointerException("L'objet POJO à convertir en DTO ne doit pas être NULL !");
		}
		if (object instanceof User) {
			User user = (User) object;
			UserDto userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setNom(user.getNom());
			userDto.setPrenom(user.getPrenom());
			userDto.setEmail(user.getEmail());
			userDto.setPassword(
					CryptageDES.decrypt(user.getPassword(),
					Conversion.convertBytesToKey(user.getCleCryptage())));
			return userDto;
		}
		if (object instanceof CartePaiement) {
			CartePaiement cartePaiement = (CartePaiement) object;
			CartePaiementDto cartePaiementDto = new CartePaiementDto();
			cartePaiementDto.setId(cartePaiement.getId());
			cartePaiementDto.setNomComplet(cartePaiement.getNomComplet());
			cartePaiementDto.setDateValidite(Conversion.convertDateUtilToString(cartePaiement.getDateValidite()));
			cartePaiementDto.setNumeroCarte(
					CryptageDES.decrypt(cartePaiement.getNumero(),
					Conversion.convertBytesToKey(cartePaiement.getCleCryptage())));
			cartePaiementDto.setCryptogramme(
					CryptageDES.decrypt(cartePaiement.getCryptogramme(),
					Conversion.convertBytesToKey(cartePaiement.getCleCryptage())));
			return cartePaiementDto;
		}
		return null;
	}

	public final static Object convertFromDtoToPojo(Object object) throws Exception {
		
		if (object == null) {
			throw new NullPointerException("L'objet DTO à convertir en POJO ne doit pas être NULL !");
		}
		if (object instanceof UserDto) {
			
		}
		if (object instanceof CartePaiementDto) {
			
		}
		return null;
	}

}
