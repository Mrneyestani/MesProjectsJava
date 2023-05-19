package fr.doranco.hibernate.model.dao.interfaces;

import fr.doranco.hibernate.entity.Param;

public interface IParamDao {

	void addSecurityKey(Param param) throws Exception;
	Param getSecurityKeyById(Integer id) throws Exception;

}
