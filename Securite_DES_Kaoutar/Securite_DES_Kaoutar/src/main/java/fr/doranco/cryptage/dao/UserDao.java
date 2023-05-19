package fr.doranco.cryptage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import fr.doranco.cryptage.connexion.DataBaseConnection;
import fr.doranco.cryptage.entity.CartePaiment;
import fr.doranco.cryptage.entity.User;


public class UserDao implements IUserDao {

	private final ICartePaiementDao cartePaimentDao = new CartePaiementDao();

	@Override
	public User addUser(User user) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "INSERT INTO user(nom, prenom, email, password) VALUES(?,?,?,?)";
			ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getEmail());
			ps.setBytes(4, user.getPassword());
			

			ps.executeUpdate();
			rs = ps.getGeneratedKeys();

			if (rs != null && rs.next()) {
				user.setId(rs.getInt(1));
			}
			
			if (user.getCartesPaiment() != null && !user.getCartesPaiment().isEmpty()) {
				for (CartePaiment cp : user.getCartesPaiment()) {
					cartePaimentDao.addCartePaiement(cp, user.getId());
				}
			}

			} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		return user;
	}


	@Override
	public User getUserById(int id) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM user WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, id);

			ps.execute();
			rs = ps.getResultSet();

			if (rs != null && rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getBytes("password"));
				
			}
			
		
			List<CartePaiment> cartesPaiments = new ArrayList<CartePaiment>() ;
			cartesPaiments = cartePaimentDao.getCartesPaiements(id);
			System.out.println("");
			System.out.println(cartesPaiments.size());
			for (CartePaiment cp : cartesPaiments) {
				user.getCartesPaiment().add(cp);
			}

			
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		return user;
	}





	@Override
	public User getUserByEmail(String emial) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void updateUser(User user) throws Exception {
//
//		Connection connection = null;
//		PreparedStatement ps = null;
//
//		try {
//			connection = DataBaseConnection.getConnection();
//			String requete = "UPDATE user SET nom = ?, prenom = ?, date_naissance = ? WHERE id = ?";
//			ps = connection.prepareStatement(requete);
//			ps.setString(1, user.getNom());
//			ps.setString(2, user.getPrenom());
//			ps.setDate(3, Dates.convertDateUtilToSql(user.getDateNaissance()));
//			ps.setInt(4, user.getId());
//
//			ps.executeUpdate();
//
//		} finally {
//
//			if (ps != null && !ps.isClosed()) {
//				ps.close();
//			}
//			if (connection != null && !connection.isClosed()) {
//				connection.close();
//			}
//		}
//	}

//	@Override
//	public void deleteUser(int id) throws Exception {
//
//		adresseDao.deleteAdresses(id);
//		cartePaimentDao.annuleCartePaiement(id);
//
//		Connection connection = null;
//		PreparedStatement ps = null;
//		try {
//			connection = DataBaseConnection.getConnection();
//			String requete = "DELETE FROM user WHERE id = ?";
//			ps = connection.prepareStatement(requete);
//			ps.setInt(1, id);
//
//			ps.executeUpdate();
//
//		} finally {
//
//			if (ps != null && !ps.isClosed()) {
//				ps.close();
//			}
//			if (connection != null && !connection.isClosed()) {
//				connection.close();
//			}
//		}
//	}

//	@Override
//	public List<User> getUsers() throws Exception {
//		Connection connection = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		List<User> users = new ArrayList<User>();
//		try {
//			connection = DataBaseConnection.getConnection();
//			String requete = "SELECT * FROM user";
//			ps = connection.prepareStatement(requete);
//
//			ps.execute();
//			rs = ps.getResultSet();
//
//			if (rs != null) {
//				while (rs.next()) {
//					User user = new User();
//					user.setId(rs.getInt("id"));
//					user.setNom(rs.getString("nom"));
//					user.setPrenom(rs.getString("prenom"));
//					user.setDateNaissance(Dates.convertDateSqlToUtil(rs.getDate("date_naissance")));
//
//					List<Adresse> adresses = adresseDao.getAdresses(rs.getInt("id"));
//					for (Adresse a : adresses) {
//						user.getAdresses().add(a);
//					}
//
//					List<CartePaiement> CartesPaiments = cartePaimentDao.getCartesPaiements(user.getId());
//					for (CartePaiement cp : CartesPaiments) {
//						user.getCartesPaiment().add(cp);
//					}
//
//					List<Commande> Commandes = commandeDao.getCommandes(user.getId());
//					for (Commande cmd : Commandes) {
//						user.getCommandes().add(cmd);
//					}
//
//					users.add(user);
//				}
//			}
//		} finally {
//			if (rs != null && !rs.isClosed()) {
//				rs.close();
//			}
//			if (ps != null && !ps.isClosed()) {
//				ps.close();
//			}
//			if (connection != null && !connection.isClosed()) {
//				connection.close();
//			}
//		}
//		return users;
//	}

}
