package fr.spring.eBoutique.project.dao;


import fr.spring.eBoutique.project.BDD.DataSourceConnexion;
import fr.spring.eBoutique.project.model.Commande;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO implements ICommandeDAO {

private Connection connexion= null;
	
	public CommandeDAO() {
		if (connexion == null) {
			try {
				connexion= DataSourceConnexion.getInstance().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//-------------------------------------------------------------------------
	@Override
	public Commande getCommande(Integer idUtilisatuer) {
		
		Commande commande=null;
		ResultSet rs=null;
		
		try {
			String requete= "SELECT * FROM commande WHERE utilisatuer_id=?";
			PreparedStatement ps=connexion.prepareStatement(requete);
			ps.setInt(1, idUtilisatuer);
			rs=ps.executeQuery();
			
					if (rs !=null && rs.next()) {
						commande = new Commande();
						commande.setId(rs.getInt("id"));
						commande.setDateCreation(LocalDateTime.parse(rs.getString("date_creation")));
						commande.setDateLivraison(LocalDateTime.parse(rs.getString("date_livraison")));
						commande.setPrix_total(rs.getInt("prix_total"));
						}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connexion !=null) {
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
			return commande;
}
//--------------------------------------------------------------------------------------------
	@Override
	public Commande addCommande(Commande commande) {
		
		 Commande commandeAdded=null;
		try {
			String requete="INSERT INTO commande (date_creation, date_livraison, prix_total) VALUES (?,?,?)";
		    PreparedStatement ps=connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1, String.valueOf(commande.getDateCreation()));
			ps.setString(2, String.valueOf(commande.getDateLivraison()));
			ps.setFloat(3, commande.getPrix_total());
			ps.executeUpdate();
			commandeAdded = commande;
		
		    ResultSet rs=ps.getGeneratedKeys();
			if (rs.next()) {
				commandeAdded.setId(rs.getInt(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (connexion !=null) {
				try {
					connexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
		}
		return commandeAdded;	
	}	
//----------------------------------------------------------------------------------------------
	@Override
	public List<Commande> getCommandes(Integer idUtilisatuer) {
		
		List<Commande> listeCommande = null;
		ResultSet rs=null;
		
		try {
			String query = "SELECT * FROM commande WHERE utilisateur_id =?";
			Statement stm = connexion.createStatement();
			rs=stm.executeQuery(query);
			if (rs !=null) {
				listeCommande = new ArrayList<Commande>();
				while (rs.next()) {
					Commande commande= new Commande();
					commande.setId(rs.getInt("id"));
					commande.setDateCreation(LocalDateTime.parse(rs.getString("date_creation")));
					commande.setDateLivraison(LocalDateTime.parse(rs.getString("date_livraison")));
					commande.setPrix_total(rs.getFloat("prix_total"));
					listeCommande.add(commande);
					}	
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connexion !=null) {
				try {
					connexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
		}
		return listeCommande;
}

}
