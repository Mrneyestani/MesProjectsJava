package fr.doranco.cryptage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.cryptage.connexion.DataBaseConnection;
import fr.doranco.cryptage.entity.CartePaiment;
import fr.doranco.cryptage.utils.Dates;

public class CartePaiementDao implements ICartePaiementDao {

	@Override
	public CartePaiment addCartePaiement(CartePaiment cartePaiment, int userId) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "INSERT INTO carte_paiement(numero_carte, date_validite, cryptogramme, user_id) " + "VALUES(?,?,?,?)";
			ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setBytes(1, cartePaiment.getNumeroCarte());
			ps.setDate(2, Dates.convertDateUtilToSql(cartePaiment.getDateValidite()));
			ps.setBytes(3, cartePaiment.getCryptogramme());
			ps.setInt(4, userId);
			
			System.out.println("Reuqute:  " +requete);
             
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			if (rs != null && rs.next()) {
				cartePaiment.setId(rs.getInt(1));
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
		return cartePaiment;
	}
	

	@Override
	public CartePaiment getCartePaiementById(int id) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CartePaiment cartePaiement = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM carte_paiement WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, id);

			ps.execute();

			rs = ps.getResultSet();

			if (rs != null && rs.next()) {
				
				cartePaiement = new CartePaiment();
				cartePaiement.setId(rs.getInt("id"));
				cartePaiement.setNumeroCarte(rs.getBytes("numero_carte"));
				cartePaiement.setDateValidite(Dates.convertDateSqlToUtil(rs.getDate("date_validite")));
				cartePaiement.setCryptogramme(rs.getBytes("cryptogramme"));
			}
			
			System.out.println("Requete get carte paimnt by id user " + requete );

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
		return cartePaiement ;
	}

	

	@Override
	public List<CartePaiment> getCartesPaiements(int userId) throws Exception {

			Connection connection = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			CartePaiment cartePaiement = null;
			List<CartePaiment> cartesPaiement = new ArrayList<CartePaiment>();
			try {
				connection = DataBaseConnection.getConnection();
				String requete = "SELECT * FROM carte_paiement WHERE user_id = ?";
				ps = connection.prepareStatement(requete);
				ps.setInt(1, userId);

				ps.execute();

				rs = ps.getResultSet();

				if (rs != null) {
					while (rs.next()) {
												
						cartePaiement = new CartePaiment();
						cartePaiement.setId(rs.getInt("id"));
						cartePaiement.setNumeroCarte(rs.getBytes("numero_carte"));
						cartePaiement.setDateValidite(Dates.convertDateSqlToUtil(rs.getDate("date_validite")));
						cartePaiement.setCryptogramme(rs.getBytes("cryptogramme"));
					
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
	
	

//	@Override
//	public void annuleCartePaiement(int userId) throws Exception {
//
//		Connection connection = null;
//		PreparedStatement ps = null;
//		CartePaiement cartePaiement = new CartePaiement(); 
//		
//		try {
//			connection = DataBaseConnection.getConnection();
//			if (cartePaiement.getIsValide()) {
//				
//				String requete = "UPDATE `exemple_db`.`carte_paiement`"
//						+ "SET"
//						+ "`is_validate` = false "
//						+ " WHERE `id` = ?";
//				ps = connection.prepareStatement(requete);
//				ps.setInt(1, userId);
//			//System.out.println(ps.toString());
//				ps.executeUpdate();
//			}
//			
//
//		} finally {
//			if (ps != null && !ps.isClosed()) {
//				ps.close();
//			}
//			if (connection != null && !connection.isClosed()) {
//				connection.close();
//			}
//		}
//		
//	}
//

	

}
