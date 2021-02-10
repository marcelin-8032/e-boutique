package fr.spring.eBoutique.project.dao;


import fr.spring.eBoutique.project.BDD.DataSourceConnexion;
import fr.spring.eBoutique.project.model.CartePaiement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartePaiementDao implements ICartePaiementDAO {

	
private Connection connexion= null;
	
	public CartePaiementDao() {
		if (connexion == null) {
			try {
				connexion= DataSourceConnexion.getInstance().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//----------------------------------------------------------------------------
	@Override
	public CartePaiement getCartePaiment(Integer id) {
		
		CartePaiement cartePaiement=null;
		ResultSet rs=null;
		
		try {
			String requete= "SELECT * FROM cartepaiement WHERE id=?";
			PreparedStatement ps=connexion.prepareStatement(requete);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
					if (rs !=null && rs.next()) {
						cartePaiement = new CartePaiement();
						cartePaiement.setId(rs.getInt("id"));
						cartePaiement.setNumero(rs.getInt("numero"));
						cartePaiement.setDateValidite(rs.getString("date_validite"));
						cartePaiement.setCryptogramme(rs.getInt("cryptograme"));
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
			return cartePaiement;
}
//------------------------------------------------------------------------------------------
	@Override
	public List<CartePaiement> getCartesPaiment(Integer idUtilisateur) {
		
		List<CartePaiement> listecarteP = null;
		ResultSet rs=null;
		
		try {
			String query = "SELECT * FROM cartepaiement WHERE utilisateur_id=?";
			Statement stm = connexion.createStatement();
			rs=stm.executeQuery(query);
			
			if (rs !=null) {
				listecarteP = new ArrayList<CartePaiement>();
				while (rs.next()) {
					CartePaiement cartePaiement= new CartePaiement();
					
					cartePaiement.setId(rs.getInt("id"));
					cartePaiement.setNumero(rs.getInt("numero"));
					cartePaiement.setDateValidite(rs.getString("date_validite"));
					cartePaiement.setCryptogramme(rs.getInt("cryptograme"));
					listecarteP.add(cartePaiement);
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
		return listecarteP;
}
//----------------------------------------------------------------------------------------------
	@Override
	public CartePaiement addCartePaiement(CartePaiement cartePaiement) {
		
		CartePaiement cartepaiementadded=null;
		
			try {
				String requete="INSERT INTO cartepaiement (numero, date_validite, cryptograme) VALUES (?,?,?)";
			    PreparedStatement ps=connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			    
			    ps.setInt(1, cartePaiement.getNumero());
				ps.setString(2, cartePaiement.getDateValidite());	
				ps.setInt(3, cartePaiement.getCryptogramme());
				
				ps.executeUpdate();
				cartepaiementadded = cartePaiement;
			
			    ResultSet rs=ps.getGeneratedKeys();
				if (rs.next()) {
					cartepaiementadded.setId(rs.getInt(1));
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
			return cartepaiementadded;	
		}
//-----------------------------------------------------------------------------------------------
	@Override
	public void removeCartePaiement(Integer id) {
		
		try {			
			String requete="DELETE FROM cartepaiement Where id= ?";
			PreparedStatement ps=connexion.prepareStatement(requete);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (connexion!=null) {
					connexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
		}
		
	}

}
}
