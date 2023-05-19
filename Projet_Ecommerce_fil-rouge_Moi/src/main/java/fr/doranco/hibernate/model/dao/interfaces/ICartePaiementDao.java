package fr.doranco.hibernate.model.dao.interfaces;

import fr.doranco.hibernate.entity.CartePaiment;

public interface ICartePaiementDao {

	void addCartePaiement(CartePaiment cartePaiementCrypte, Integer userId) throws Exception;
	CartePaiment getCartePaiement(Integer id) throws Exception;
}
