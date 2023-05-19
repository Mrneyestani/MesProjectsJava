package fr.doranco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.doranco.entity.pojo.User;

public class UserDao implements IUserDao {

	public UserDao() {
	}

	@Override
	public User getUserByEmail(String email) throws Exception {

		if (email == null || email.trim().isEmpty()) {
			throw new NullPointerException("L'Email ne doit pas etre NULL ou vide !");
		}

		User user = null;
		Connection connexion = null;
		PreparedStatement ps = null;
		try {
			connexion = CryptageDataSource.getInstance().getConnection();
			String query = "SELECT * FROM user WHERE email = ?";
			ps = connexion.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getBytes("password"));
			}
		} finally {
			if (ps != null && !ps.isClosed())
				ps.close();
			if (connexion != null && !connexion.isClosed())
				connexion.close();
		}
		return user;
	}

	@Override
	public User addUser(User user) throws Exception {

		if (user == null) {
			throw new NullPointerException("L'Utilisateur à insérer dans la BDD ne doit pas être NULL !");
		}

		Connection connexion = null;
		PreparedStatement ps = null;
		try {
			connexion = CryptageDataSource.getInstance().getConnection();
			String requete = "INSERT INTO user(nom, prenom, email, password, cle_cryptage) " + "VALUES(?, ?, ?, ?, ?)";
			ps = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getEmail());
			ps.setBytes(4, user.getPassword());
			ps.setBytes(5, user.getCleCryptage());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				user.setId(id);
			}
		} finally {
			if (ps != null && !ps.isClosed())
				ps.close();
			if (connexion != null && !connexion.isClosed())
				connexion.close();
		}

		if (user.getCartePaiment() != null) {
			ICartePaiementDao cartePaiementDao = new CartePaiementDao();
			cartePaiementDao.addCartePaiement(user.getCartePaiment(), user.getId());
		}
		return user;
	}

}
