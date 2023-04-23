package fr.doranco.exemple.model.dao;

import fr.doranco.exemple.entity.CartePaiement;
import java.util.List;

public interface ICartePaiementDao {

	int addCartePaiement(CartePaiement cartePaiement, int userId) throws Exception;
	List<CartePaiement> getCartesPaiement(int userId)throws Exception;
	CartePaiement getCartePaiement(int id) throws Exception;
	void removeCartePaiement(int id) throws Exception;
	void removeCartesPaiement(int userId) throws Exception;
	
	
}
