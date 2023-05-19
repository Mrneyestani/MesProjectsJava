package fr.doranco.monprojet.model.dao;

import fr.doranco.monprojet.entity.CartePaiement;

public interface ICartePaiementDao {

	CartePaiement addCartePaiement(CartePaiement cp) throws Exception;
	CartePaiement getCartePaiement(Integer idUser) throws Exception;
}
