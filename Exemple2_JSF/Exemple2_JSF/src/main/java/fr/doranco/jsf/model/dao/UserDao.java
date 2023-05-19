package fr.doranco.jsf.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




import fr.doranco.jsf.entity.User2;
import fr.doranco.jsf.model.connection.DataBaseConnection;
import fr.doranco.jsf.utils.Dates;

public class UserDao implements IUserDao {

//	private final IAdresseDao adresseDao = new AdresseDao();
//	private final ICartePaiementDao cartePaimentDao = new CartePaiementDao();
//	private final ICommandeDao commandeDao = new CommandeDao();
	
	@Override
	public int addUser(User2 user) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "INSERT INTO user(nom, prenom, date_naissance) VALUES(?,?,?)";
			ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setDate(3, Dates.convertDateUtilToSql(user.getDateNaissance()));

			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			int id = -1;
			if (rs != null && rs.next()) {
			    id = rs.getInt(1);
			    return id;
			}
			
//			if (user.getAdresses() != null && !user.getAdresses().isEmpty()) {
//				for (Adresse a : user.getAdresses()) {
//					adresseDao.addAdresse(a, id);
//				}
//			}
			
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
		return -1;
	}

	@Override
	public User2 getUserById(int id) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User2 user = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM user WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, id);

			ps.execute();
			rs = ps.getResultSet();

			if (rs != null && rs.next()) {
				user = new User2();
				user.setId(rs.getInt("id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setDateNaissance(Dates.convertDateSqlToUtil(rs.getDate("date_naissance")));
			}
//			List<Adresse> adresses = adresseDao.getAdresses(id);
//			for (Adresse adresse : adresses) {
//				user.getAdresses().add(adresse);
//			}
//			
//			
//			List<CartePaiement> CartesPaiments = cartePaimentDao.getCartesPaiements(id);
//			for (CartePaiement cp : CartesPaiments ) {
//				user.getCartesPaiment().add(cp);
//			}
//			
//			List<Commande> Commandes = commandeDao.getCommandes(id);
//			for (Commande cmd : Commandes ) {
//				user.getCommandes().add(cmd);
//			}
			
			
			
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

	@Override
	public List<User2> getUsers() throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User2> users = new ArrayList<User2>();
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM user";
			ps = connection.prepareStatement(requete);

			ps.execute();
			rs = ps.getResultSet();

			if (rs != null) {
				while (rs.next()) {
					User2 user = new User2();
					user.setId(rs.getInt("id"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setDateNaissance(Dates.convertDateSqlToUtil(rs.getDate("date_naissance")));
					
//					List<Adresse> adresses = adresseDao.getAdresses(rs.getInt("id"));
//					for (Adresse a : adresses) {
//						user.getAdresses().add(a);
//					}
//					
//					List<CartePaiement> CartesPaiments = cartePaimentDao.getCartesPaiements(user.getId());
//					for (CartePaiement cp : CartesPaiments ) {
//						user.getCartesPaiment().add(cp);
//					}
//					
//					List<Commande> Commandes = commandeDao.getCommandes(user.getId());
//					for (Commande cmd : Commandes ) {
//						user.getCommandes().add(cmd);
//					}
					
					users.add(user);
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
		return users;
	}

}
