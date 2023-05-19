package fr.doranco.monprojet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.doranco.monprojet.entity.CartePaiement;
import fr.doranco.monprojet.entity.User;
import fr.doranco.monprojet.model.connection.MySqlDS;

public class UserDao implements IUserDao {

	@Override
	public User addUser(User user) throws Exception {
		
		if (user == null) {
			throw new NullPointerException("L'objet user � ajouter dans la BDD ne doit pas être NULL !");
		}
		if (user.getNom() == null || user.getNom().isEmpty()
				|| user.getPrenom() == null || user.getPrenom().isEmpty()
				|| user.getEmail() == null || user.getEmail().isEmpty()
				|| user.getPassword() == null || user.getPassword().length == 0
				|| user.getCleCryptage() == null || user.getCleCryptage().length == 0) {

			throw new IllegalArgumentException(
					"Un ou plusieurs param�tres du user à ajouter dans la BDD est(sont) manquant(s) !");
		}

		String requete = "INSERT INTO user(nom, prenom, email, password, cle_cryptage) VALUES(?,?,?,?,?)";
		Connection connection = MySqlDS.getInstance().getConnection();
		PreparedStatement ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, user.getNom());
		ps.setString(2, user.getPrenom());
		ps.setString(3, user.getEmail());
		ps.setBytes(4, user.getPassword());
		ps.setBytes(5, user.getCleCryptage());

		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
			user.setId(rs.getInt(1));
			user.getCartePaiement().setUserId(rs.getInt(1));
		}
		if (user.getCartePaiement() != null) {
			ICartePaiementDao cpDao = new CartePaiementDao();
			CartePaiement cp = cpDao.addCartePaiement(user.getCartePaiement());
			user.getCartePaiement().setId(cp.getId());
		}
		return user;
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		
		if (email == null || email.isEmpty()) {
			throw new NullPointerException("L'email du user doit être non NULL et non vide !");
		}
		String requete = "SELECT * FROM user WHERE email = ?";
		Connection connection = MySqlDS.getInstance().getConnection();
		PreparedStatement ps = connection.prepareStatement(requete);
		ps.setString(1, email);

		User user = null;
		ResultSet rs = ps.executeQuery();
		if (rs != null && rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setNom(rs.getString("nom"));
			user.setPrenom(rs.getString("prenom"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getBytes("password"));
			user.setCleCryptage(rs.getBytes("cle_cryptage"));
		}
		ICartePaiementDao cpDao = new CartePaiementDao();
		CartePaiement cp = cpDao.getCartePaiement(user.getId());
		user.setCartePaiement(cp);
		return user;
	}

}
