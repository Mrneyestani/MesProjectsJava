package fr.doranco.cryptage.dao.interfaces;

import fr.doranco.cryptage.entity.SecurityKey;

public interface ISecurityKey {

	void addSecurityKey(SecurityKey securityKey) throws Exception;
	SecurityKey getSecurityKeyById(Integer id) throws Exception;

}
