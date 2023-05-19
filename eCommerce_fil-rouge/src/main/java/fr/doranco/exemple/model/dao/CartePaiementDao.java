package fr.doranco.exemple.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import fr.doranco.exemple.entity.CartePaiement;
import fr.doranco.exemple.model.connection.DataBaseConnection;

public class CartePaiementDao implements ICartePaiementDao {

	@Override
	public CartePaiement addCartePaiement(CartePaiement cartePaiement, Integer userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartePaiement getCartePaiementById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartePaiement> getCartesPaiement(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelCartePaiement(Integer id) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			String requete = "UPDATE carte_paiement SET valable = false WHERE id = ?";
			connection = DataBaseConnection.getConnection();
			ps = connection.prepareStatement(requete);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} finally {
			if (connection != null & !connection.isClosed()) {
				connection.close();
			}
			if (ps != null & !ps.isClosed()) {
				ps.close();
			}
		}
	}

}
