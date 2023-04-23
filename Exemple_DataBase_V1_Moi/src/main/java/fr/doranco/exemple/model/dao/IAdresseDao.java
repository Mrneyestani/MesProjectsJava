package fr.doranco.exemple.model.dao;

import fr.doranco.exemple.entity.Adresse;


public interface IAdresseDao {

	int addAdresse(Adresse adresse,int userId) throws Exception;
	Adresse getAdresseById(int id) throws Exception;
	void updateAdresse(Adresse adresse) throws Exception;
	void deleteAdresse(int id) throws Exception;
	
}
