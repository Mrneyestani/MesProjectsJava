package fr.doranco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.doranco.entity.pojo.CartePaiement;
import fr.doranco.utils.Conversion;

public class CartePaiementDao implements ICartePaiementDao {

	@Override
	public CartePaiement getCartePaiementByUserId(Integer userId) throws Exception {
		
		if (userId == null) {
			throw new NullPointerException("L'id de l'utilisateur est NULL !");
		}
		CartePaiement cartePaiement = null;
		Connection connexion = null;
		PreparedStatement ps = null;
		try {
			connexion = CryptageDataSource.getInstance().getConnection();
			String query = "SELECT * FROM carte_paiement WHERE user_id = ?";
			 ps = connexion.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cartePaiement = new CartePaiement();
				cartePaiement.setId(rs.getInt("id"));
				cartePaiement.setNomComplet(rs.getString("nom"));
				cartePaiement.setCleCryptage(rs.getBytes("cle_cryptage"));
				cartePaiement.setNumero(rs.getBytes("numero"));
				cartePaiement.setCryptogramme(rs.getBytes("cryptogramme"));
				cartePaiement.setDateValidite(Conversion.convertDateSqlToDateUtil(rs.getDate("date_validite")));
			}
		} finally {
			if (ps != null && !ps.isClosed())
				ps.close();
			if (connexion != null && !connexion.isClosed())
				connexion.close();
		}
		return cartePaiement;
	}

	@Override
	public CartePaiement addCartePaiement(CartePaiement cartePaiement, Integer userId) throws Exception {

		if (cartePaiement == null) {
			throw new NullPointerException("La carte de paiement à insérer dans la BDD est NULL !");
		}
		if (userId == null) {
			throw new NullPointerException("L'id de l'utilisateur est NULL !");
		}

		Connection connexion = null;
		PreparedStatement ps = null;
		try {
			connexion = CryptageDataSource.getInstance().getConnection();
			String requete = "INSERT INTO carte_paiement(numero, nom, cle_cryptage, cryptogramme, date_validite, user_id) "
									+ "VALUES(?, ?, ?, ?, ?, ?)";
			ps = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setBytes(1, cartePaiement.getNumero());
			ps.setString(2, cartePaiement.getNomComplet());
			ps.setBytes(3, cartePaiement.getCleCryptage());
			ps.setBytes(4, cartePaiement.getCryptogramme());
			ps.setDate(5, Conversion.convertDateUtilToDateSql(cartePaiement.getDateValidite()));
			ps.setInt(6, userId);

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				cartePaiement.setId(id);
			}
		} finally {
			if (ps != null && !ps.isClosed())
				ps.close();
			if (connexion != null && !connexion.isClosed())
				connexion.close();
		}
		return cartePaiement;	}

}
