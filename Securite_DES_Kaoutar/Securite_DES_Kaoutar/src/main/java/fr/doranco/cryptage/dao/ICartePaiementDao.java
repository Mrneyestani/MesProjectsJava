package fr.doranco.cryptage.dao;

import java.util.List;

import fr.doranco.cryptage.entity.CartePaiment;




public interface ICartePaiementDao {
	
	CartePaiment addCartePaiement(CartePaiment cartePaiment, int userId)  throws Exception;
	CartePaiment getCartePaiementById(int id) throws Exception;
	//CartePaiment getCartePaiementByUserId(int userId) throws Exception;
	List<CartePaiment>getCartesPaiements(int userId) throws Exception;
	
//	void annuleCartePaiement(int userId) throws Exception;

}
