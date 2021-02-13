package fr.spring.eBoutique.project.dao;



import fr.spring.eBoutique.project.BDD.DataSourceConnexion;
import fr.spring.eBoutique.project.model.Categorie;
import fr.spring.eBoutique.project.model.Produit;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "ProduitDao")
public class ProduitDAOImpl implements IProduitDAO {

@Autowired
	private SessionFactory sessionFactory;


private Connection connexion= null;
	
	public ProduitDAOImpl() {
		if (connexion == null) {
			try {
				connexion= DataSourceConnexion.getInstance().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//---------------------------------------------------------------------
	@Override
	public Produit getProduit(Integer id) {
		
		Produit produit=null;
		ResultSet rs=null;
		
		try {
			String requete= "SELECT * FROM produit WHERE id=?";
			PreparedStatement ps=connexion.prepareStatement(requete);
			
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
					if (rs !=null && rs.next()) {
						produit = new Produit();
						produit.setId(rs.getLong("id"));
						produit.setNom(rs.getString("nom"));
						produit.setDescription(rs.getString("description"));
						produit.setPrix(rs.getFloat("prix"));
						produit.setRemise(rs.getInt("remise"));
						produit.setCategorie(Categorie.valueOf(rs.getString("categorie")));
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
			return produit;
}
//--------------------------------------------------------------------------
	@Override
	public List<Produit> getProduitsByCategorie(String categorie) {
		
		List<Produit> listeProduitCtg = null;
		ResultSet rs=null;
		
		try {
			String query = "SELECT * FROM produit WHERE categorie =?";
			Statement stm = connexion.createStatement();
			rs=stm.executeQuery(query);
			
			if (rs !=null) {
				
				listeProduitCtg = new ArrayList<Produit>();
				while (rs.next()) {
					Produit produit= new Produit();
					produit.setId(rs.getLong("id"));
					produit.setNom(rs.getString("nom"));
					produit.setDescription(rs.getString("description"));
					produit.setPrix(rs.getFloat("prix"));
					produit.setRemise(rs.getInt("remise"));
					produit.setCategorie(Categorie.valueOf(rs.getString("categorie")));
					listeProduitCtg.add(produit);
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
		return listeProduitCtg;
}
//----------------------------------------------------------------------------------------
	@Override
	public Produit addProduit(Produit produit) {
		Produit produitadded=null;
		
		try {
			String requete="INSERT INTO produit (nom, description, prix, remise, categorie) VALUES (?,?,?,?,?)";
		    PreparedStatement ps=connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1, produit.getNom());
			ps.setString(2, produit.getDescription());	
			ps.setFloat(3, produit.getPrix());
			ps.setInt(4, produit.getRemise());
			ps.setString(5, String.valueOf(produit.getCategorie()));
			ps.executeUpdate();
			
			produitadded = produit;
		
		    ResultSet rs=ps.getGeneratedKeys();
			if (rs.next()) {
				produitadded.setId(rs.getLong(1));
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
		return produitadded;	
	}	
//------------------------------------------------------------------------------------------
	@Override
	public void updateProduit(Produit produit) {
		
		try {
			String requete = "UPDATE produit SET nom=?, description =?, prix =?, remise=?, categorie=?, WHERE id = ?";
			PreparedStatement ps=connexion.prepareStatement(requete);
			
			ps.setString(1, produit.getNom());
			ps.setString(2, produit.getDescription());	
			ps.setFloat(3, produit.getPrix());
			ps.setInt(4, produit.getRemise());
			ps.setString(5, String.valueOf(produit.getCategorie()));
			ps.executeUpdate();

		} catch (SQLException e) {
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
}
//---------------------------------------------------------------------------------------
	@Override
	public void removeProduit(Integer id) {
		
		try {			
			String requete="DELETE FROM produit Where id= ?";
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
				// TODO: handle exception
				e.printStackTrace();
		}
		
	}
		
}
}
