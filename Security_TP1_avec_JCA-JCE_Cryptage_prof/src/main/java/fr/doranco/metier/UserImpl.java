package fr.doranco.metier;

import javax.crypto.SecretKey;

import fr.doranco.cryptage.algo.CryptageDES;
import fr.doranco.cryptage.keys.GenerateKey;
import fr.doranco.dao.IUserDao;
import fr.doranco.dao.UserDao;
import fr.doranco.entity.dto.CartePaiementDto;
import fr.doranco.entity.dto.UserDto;
import fr.doranco.entity.pojo.CartePaiement;
import fr.doranco.entity.pojo.User;
import fr.doranco.enums.AlgorithmeCryptage;
import fr.doranco.utils.Conversion;

public final class UserImpl implements IUserImpl {

	private IUserDao userDao = new UserDao();
	
	@Override
	public final User getUserByEmail(String email) throws Exception {
		
		if (email == null || email.trim().isEmpty()) {
			throw new NullPointerException("L'Email ne doit pas être NULL ou vide !");
		}
		return userDao.getUserByEmail(email);
	}

	@Override
	public final User addUser(UserDto userDto) throws Exception {

		if (userDto == null) {
			throw new NullPointerException("L'Utilisateur à ajouter ne doit pas être NULL !");
		}
		User user = new User();
		user.setNom(userDto.getNom().toUpperCase());
		user.setPrenom(userDto.getPrenom());
		user.setEmail(userDto.getEmail());
		
		SecretKey secretKey = GenerateKey.getKey(AlgorithmeCryptage.DES.toString(), 56);
		byte[] cleCryptage = secretKey.getEncoded();
		byte[] cryptedPassword = CryptageDES.encrypt(userDto.getPassword(), secretKey);
		user.setCleCryptage(cleCryptage);
		user.setPassword(cryptedPassword);
		
		CartePaiement cartePaiement = new CartePaiement();
		CartePaiementDto cartePaiementDto = userDto.getCartePaiementDto();
		if (cartePaiementDto != null) {
			cartePaiement.setDateValidite(Conversion.convertStringToDateUtil(cartePaiementDto.getDateValidite()));
			cartePaiement.setNomComplet(cartePaiementDto.getNomComplet().toUpperCase());
			
			byte[] cryptedNumero = CryptageDES.encrypt(cartePaiementDto.getNumeroCarte(), secretKey);
			byte[] cryptedCryptogramme = CryptageDES.encrypt(cartePaiementDto.getCryptogramme(), secretKey);
			cartePaiement.setCleCryptage(cleCryptage);
			cartePaiement.setNumero(cryptedNumero);
			cartePaiement.setCryptogramme(cryptedCryptogramme);
			
			user.setCartePaiement(cartePaiement);
		}
		
		return userDao.addUser(user);
	}

	@Override
	public final User seLoguer(String email, String password) throws Exception {
		return null;
	}

}
