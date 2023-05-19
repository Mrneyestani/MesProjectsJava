package fr.doranco.dao;

import fr.doranco.entity.pojo.CartePaiement;

public interface ICartePaiementDao {
	
	CartePaiement getCartePaiementByUserId(Integer userId) throws Exception;
	CartePaiement addCartePaiement(CartePaiement cartePaiement, Integer userId) throws Exception;
}
