package fr.doranco.cryptage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.cryptage.connexion.DataBaseConnection;
import fr.doranco.cryptage.entity.CartePaiment;
import fr.doranco.cryptage.entity.Param;
import fr.doranco.cryptage.entity.User;


public class ParamDao {
	
	
	public Param addParamKey(Param paramKey) throws Exception {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "INSERT INTO param(cle) " + "VALUES(?)";
			ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setBytes(1, paramKey.getCleByte());
			
			
			
			System.out.println("Reuqute:  " +requete);
             
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			
			if (rs != null && rs.next()) {
				paramKey.setId(rs.getInt(1));
			}

		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		return paramKey;
	}
	
	
	public Param getParamById(int id) throws Exception {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Param param = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT id , cle  FROM param WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, id);

			ps.execute();
			rs = ps.getResultSet();

			if (rs != null && rs.next()) {
				param = new Param();
				param.setId(rs.getInt("id"));
				param.setCleByte(rs.getBytes("cle"));
			
			}
			
			
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		return param;
	}


	
	
	
}