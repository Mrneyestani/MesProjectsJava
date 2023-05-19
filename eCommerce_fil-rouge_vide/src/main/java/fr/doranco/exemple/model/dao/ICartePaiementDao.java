package fr.doranco.exemple.model.dao;

import java.util.List;

import fr.doranco.exemple.entity.CartePaiement;

public interface ICartePaiementDao {

	CartePaiement addCartePaiement(CartePaiement cartePaiement, Integer userId) throws Exception;
	CartePaiement getCartePaiementById(Integer id) throws Exception;
	List<CartePaiement> getCartesPaiement(Integer userId) throws Exception;
	void cancelCartePaiement(Integer id) throws Exception;
}
