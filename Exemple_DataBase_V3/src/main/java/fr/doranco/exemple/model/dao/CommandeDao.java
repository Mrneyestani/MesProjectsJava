package fr.doranco.exemple.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.exemple.entity.Adresse;
import fr.doranco.exemple.entity.CartePaiement;
import fr.doranco.exemple.entity.Commande;
import fr.doranco.exemple.model.connection.DataBaseConnection;
import fr.doranco.exemple.utils.Dates;

public class CommandeDao implements ICommandeDao{

	
	@Override
	public int addCommande(Commande commande, int adresseLivraisonId, int adresseFacturationId, int cartePaiementId, int userId) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = -1;
		try {

			connection = DataBaseConnection.getConnection();
			String requete = "INSERT INTO commande(numero_commande,statut,mode_livraison,date_creation,date_livraison,adresse_livraison_id,adresse_facturation_id,carte_paiement_id,user_id)" + "VALUES(?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);				
			ps.setInt(1, commande.getNumeroCommande());
			ps.setString(2, commande.getStatut());
			ps.setString(3, commande.getModeLivraison());
			ps.setDate(4, Dates.convertDateUtilToSql(commande.getDateCreation()));
			ps.setDate(5, Dates.convertDateUtilToSql(commande.getDateLivraison()));
			ps.setInt(6, adresseLivraisonId);
			ps.setInt(7, adresseFacturationId);
			ps.setInt(8, cartePaiementId);
			ps.setInt(9, userId);
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
				id = rs.getInt(1);
			   commande.setId(id);
			}
			
//			if (commande.getDateAnnulation() != null) {}
			//Adresse adresseLivraison = adresseDao.getAdresse(adresseLivraisonId);
//			System.out.println("Adresse de livraison : ");
//			System.out.println(adresseLivraison);
			//Adresse adresseFacturation = adresseDao.getAdresse(adresseFacturationId);
//			System.out.println("Adresse de facturation : ");
//			System.out.println(adresseFacturation);
			
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
		return id;
	}

	
//	@Override
//	public void addCommandeByUserId(Commande commande, int userId) {
//
//		Connection connection = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		int id = -1;
//		try {
////			final IAdresseDao adresseDao = new AdresseDao();
//			connection = DataBaseConnection.getConnection();
//			String requete = "INSERT INTO commande(numero_commande,statut,mode_livraison,date_creation,date_livraison,adresse_livraison_id,adresse_facturation_id,carte_paiement_id,user_id)" + "VALUES(?,?,?,?,?,?,?,?,?)";
//			ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);				
//			ps.setInt(1, commande.getNumeroCommande());
//			ps.setString(2, commande.getStatut());
//			ps.setString(3, commande.getModeLivraison());
//			ps.setDate(4, Dates.convertDateUtilToSql(commande.getDateCreation()));
//			ps.setDate(5, Dates.convertDateUtilToSql(commande.getDateLivraison()));
//			ps.setInt(6, adresseLivraisonId);
//			ps.setInt(7, adresseFacturationId);
//			ps.setInt(8, cartePaiementId);
//			ps.setInt(9, userId);
//			
//			ps.executeUpdate();
//			rs = ps.getGeneratedKeys();
//			if (rs != null && rs.next()) {
//				id = rs.getInt(1);
//			   commande.setId(id);
//			}
//			
//			if (commande.getDateAnnulation() != null) {}
			//Adresse adresseLivraison = adresseDao.getAdresse(adresseLivraisonId);
//			System.out.println("Adresse de livraison : ");
//			System.out.println(adresseLivraison);
			//Adresse adresseFacturation = adresseDao.getAdresse(adresseFacturationId);
//			System.out.println("Adresse de facturation : ");
//			System.out.println(adresseFacturation);
			
//		} finally {
//			if (rs != null && !rs.isClosed()) {
//				rs.close();
//			}
//			if (ps != null && !ps.isClosed()) {
//				ps.close();
//			}
//			if (connection != null && !connection.isClosed()) {
//				connection.close();
//			}
//		}
//		
//	}

	
	
	@Override
	public Commande getCommandeById(int id) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Commande commande = null;
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM commande WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, id);

			ps.execute();

			rs = ps.getResultSet();
			
			if (rs != null && rs.next()) {
				commande = new Commande();
				commande.setId(rs.getInt("id"));
				commande.setNumeroCommande(rs.getInt("numero_commande"));
				commande.setStatut(rs.getString("statut"));
				commande.setModeLivraison(rs.getString("mode_livraison"));
				commande.setDateCreation(Dates.convertDateSqlToUtil(rs.getDate("date_creation")));
				commande.setDateLivraison(Dates.convertDateSqlToUtil(rs.getDate("date_livraison")));
				commande.setDateAnnulation(Dates.convertDateSqlToUtil(rs.getDate("date_annulation")));
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
			return commande;
	}
		
		

	@Override
	public List<Commande> getCommandes(int userId) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			connection = DataBaseConnection.getConnection();
			String requete = "SELECT * FROM commande WHERE user_id = ?";
			ps = connection.prepareStatement(requete);
			ps.setInt(1, userId);

			ps.execute();

			rs = ps.getResultSet();
			if (rs != null) {
				while (rs.next()) {
					Commande commande = new Commande();
					commande.setId(rs.getInt("id"));
					commande.setNumeroCommande(rs.getInt("numero_commande"));
					commande.setStatut(rs.getString("statut"));
					commande.setModeLivraison(rs.getString("mode_livraison"));
					commande.setDateCreation(Dates.convertDateSqlToUtil(rs.getDate("date_creation")));
					commande.setDateLivraison(Dates.convertDateSqlToUtil(rs.getDate("date_livraison")));
//					commande.setDateAnnulation(Dates.convertDateSqlToUtil(rs.getDate("date_annulation")));
					commandes.add(commande);
				}
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
		return commandes;
	}



	@Override
	public void updateCommande(Commande commande) throws Exception {
		
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = DataBaseConnection.getConnection();
			String requete = "UPDATE commande SET statut = ?, date_livraison = ? WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setString(1, commande.getStatut());
			ps.setDate(2, Dates.convertDateUtilToSql(commande.getDateLivraison()));
			ps.setInt(3, commande.getId());
			ps.executeUpdate();
			
		} finally {

			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}
	

	@Override
	public void annulerCommande(Commande commande) throws Exception {
	
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = DataBaseConnection.getConnection();
			String requete = "UPDATE commande SET statut = ?, date_annulation = ? WHERE id = ?";
			ps = connection.prepareStatement(requete);
			ps.setString(1, commande.getStatut());
			ps.setDate(2, Dates.convertDateUtilToSql(commande.getDateAnnulation()));
			ps.setInt(3, commande.getId());
			ps.executeUpdate();
			
		} finally {

			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}




	
	
}


