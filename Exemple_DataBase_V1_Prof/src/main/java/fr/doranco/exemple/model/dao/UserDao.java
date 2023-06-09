package fr.doranco.exemple.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.exemple.entity.User;
import fr.doranco.exemple.model.connection.DataBaseConnection;
import fr.doranco.exemple.utils.Dates;

public class UserDao implements IUserDao {

	@Override
	public int addUser(User user) throws Exception {

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
			if (rs != null && rs.next()) {
				return rs.getInt(1);
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
		return -1;
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
				user.setDateNaissance(Dates.convertDateSqlToUtil(rs.getDate("date_naissance")));
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
	public void updateUser(User user) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = DataBaseConnection.getConnection();
			String requete = "UPDATE user SET nom = ?, prenom = ?, date_naissance = ? WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setDate(3, Dates.convertDateUtilToSql(user.getDateNaissance()));
			ps.setInt(4, user.getId());

			ps.executeUpdate();

		} finally {

			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public void deleteUser(int id) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "DELETE FROM user WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, id);

			ps.executeUpdate();

		} finally {

			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@Override
	public List<User> getUsers() throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM user";
			ps = connection.prepareStatement(requete);

			ps.execute();
			rs = ps.getResultSet();

			if (rs != null) {
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setDateNaissance(Dates.convertDateSqlToUtil(rs.getDate("date_naissance")));
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
