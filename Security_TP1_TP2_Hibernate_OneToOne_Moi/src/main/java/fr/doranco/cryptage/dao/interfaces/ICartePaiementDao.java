package fr.doranco.cryptage.dao.interfaces;

import fr.doranco.cryptage.entity.CartePaiementCrypte;

public interface ICartePaiementDao {

//	void addCartePaiement(CartePaiementCrypte cartePaiementCrypte, Integer userId) throws Exception;
	CartePaiementCrypte getCartePaiement(Integer id) throws Exception;
}
