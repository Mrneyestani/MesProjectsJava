package fr.doranco.monprojet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.doranco.monprojet.entity.CartePaiement;
import fr.doranco.monprojet.model.connection.MySqlDS;
import fr.doranco.monprojet.utils.Dates;

public class CartePaiementDao implements ICartePaiementDao {

	@Override
	public CartePaiement addCartePaiement(CartePaiement cp) throws Exception {
		
		if (cp == null) {
			throw new NullPointerException("L'objet CartePaiement à ajouter dans la BDD ne doit pas être NULL !");
		}
		if (cp.getTitulaire() == null || cp.getTitulaire().isEmpty()
				|| cp.getNumeroCarte() == null || cp.getNumeroCarte().length == 0
				|| cp.getCryptogramme() == null || cp.getCryptogramme().length == 0
				|| cp.getDateValidite() == null
				|| cp.getUserId() == null || cp.getUserId() <= 0) {

			throw new IllegalArgumentException(
					"Un ou plusieurs paramètres de la carte de paiement à ajouter dans la BDD est(sont) manquant(s) !");
		}

		String requete = "INSERT INTO carte_paiement(titulaire, numero, date_validite, crypto, user_id) VALUES(?,?,?,?,?)";
		Connection connection = MySqlDS.getInstance().getConnection();
		PreparedStatement ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, cp.getTitulaire());
		ps.setBytes(2, cp.getNumeroCarte());
		ps.setDate(3, Dates.dateUtilToSql(cp.getDateValidite()));
		ps.setBytes(4, cp.getCryptogramme());
		ps.setInt(5, cp.getUserId());

		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs != null && rs.next()) {
			cp.setId(rs.getInt(1));
		}
		return cp;
	}

	@Override
	public CartePaiement getCartePaiement(Integer idUser) throws Exception {
		
		if (idUser == null || idUser <= 0) {
			throw new NullPointerException("L'id du user doit être non NULL et > 0 !");
		}
		String requete = "SELECT * FROM carte_paiement WHERE user_id = ?";
		Connection connection = MySqlDS.getInstance().getConnection();
		PreparedStatement ps = connection.prepareStatement(requete);
		ps.setInt(1, idUser);
		
		CartePaiement cp = null;
		ResultSet rs = ps.executeQuery();
		if (rs != null && rs.next()) {
			cp = new CartePaiement();
			cp.setId(rs.getInt("id"));
			cp.setUserId(rs.getInt("user_id"));
			cp.setTitulaire(rs.getString("titulaire"));
			cp.setNumeroCarte(rs.getBytes("numero"));
			cp.setCryptogramme(rs.getBytes("crypto"));
			cp.setDateValidite(Dates.dateSqlToUtil(rs.getDate("date_validite")));
		}
		return cp;
	}

}
