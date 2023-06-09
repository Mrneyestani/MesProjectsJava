package fr.doranco.exemple.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.exemple.entity.Adresse;
import fr.doranco.exemple.entity.CartePaiement;
import fr.doranco.exemple.model.connection.DataBaseConnection;
import fr.doranco.exemple.utils.Dates;

public class CartePaiementDao implements ICartePaiementDao {

	@Override
	public int addCartePaiement(CartePaiement cartePaiement, int userId) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = -1;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "INSERT INTO carte_paiement(numero_carte, date_validite, cryptogramme, user_id) " + "VALUES(?,?,?,?)";
			ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cartePaiement.getNumeroCarte());
			ps.setDate(2, Dates.convertDateUtilToSql(cartePaiement.getDateValidite()));
			ps.setString(3, cartePaiement.getCryptogramme());
			ps.setInt(4, userId);
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
				cartePaiement.setId(id);
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
		return id;
	}

	@Override
	public CartePaiement getCartePaiement(int id) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CartePaiement cartePaiement = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM carte_paiement WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, id);

			ps.execute();

			rs = ps.getResultSet();
			
			if (rs != null && rs.next()) {
				cartePaiement = new CartePaiement();
				cartePaiement.setId(rs.getInt("id"));
				cartePaiement.setNumeroCarte(rs.getString("numero_carte"));
				cartePaiement.setDateValidite(Dates.convertDateSqlToUtil(rs.getDate("date_validite")));
				cartePaiement.setCryptogramme(rs.getString("cryptogramme"));
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
		return cartePaiement;
	}

	@Override
	public List<CartePaiement> getCartesPaiement(int userId) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CartePaiement> cartesPaiement = new ArrayList<CartePaiement>();
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM carte_paiement WHERE user_id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, userId);

			ps.execute();

			rs = ps.getResultSet();
			if (rs != null) {
				while (rs.next()) {
					CartePaiement cartePaiement = new CartePaiement();
					cartePaiement.setId(rs.getInt("id"));
					cartePaiement.setNumeroCarte(rs.getString("numero_carte"));
					cartePaiement.setDateValidite(Dates.convertDateSqlToUtil(rs.getDate("date_validite")));
					cartePaiement.setCryptogramme(rs.getString("cryptogramme"));
					cartesPaiement.add(cartePaiement);
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
		return cartesPaiement;
	}
	
	
	@Override
	public void removeCartePaiement(int id) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "DELETE FROM carte_paiement WHERE id = ?";
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
	public void removeCartesPaiement(int userId) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "DELETE FROM carte_paiement WHERE user_id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, userId);

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

	
	

}
