package fr.doranco.exemple.model.dao;

import java.util.List;

import fr.doranco.exemple.entity.Adresse;

public interface IAdresseDao {

	int addAdresse(Adresse adresse, int userId) throws Exception;
	Adresse getAdresse(int id) throws Exception;
	List<Adresse> getAdresses(int userId) throws Exception;
	void updateAdresse(Adresse adresse) throws Exception;
	void deleteAdresse(int id) throws Exception;
}
