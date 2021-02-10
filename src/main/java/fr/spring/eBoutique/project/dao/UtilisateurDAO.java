package fr.spring.eBoutique.project.dao;


import fr.spring.eBoutique.project.BDD.DataSourceConnexion;
import fr.spring.eBoutique.project.model.Adresse;
import fr.spring.eBoutique.project.model.Utilisateur;

import java.sql.*;


@SuppressWarnings("rawtypes")
public class UtilisateurDAO implements IUtilisateurDAO {

private Connection connexion= null;
	
	public UtilisateurDAO() {
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
	public Utilisateur getUtilisateurById(Integer id) {
		
		Utilisateur utilisateur=null;
		ResultSet rs=null;
		
		try {
			String requete= "SELECT * FROM utilisateur WHERE id=?";
			PreparedStatement ps=connexion.prepareStatement(requete);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
					if (rs !=null && rs.next()) {
						utilisateur = new Utilisateur();
						utilisateur.setId(rs.getInt("id"));
						utilisateur.setNom(rs.getString("nom"));
						utilisateur.setPrenom(rs.getString("prenom"));
						utilisateur.setAge(rs.getInt("age"));
						utilisateur.setActif(rs.getBoolean("actif"));
						utilisateur.setEmail(rs.getString("email"));
						utilisateur.setModePass(rs.getString("modePass"));
						utilisateur.setTelephone(rs.getString("telephone"));
						}	
					AdresseDAO adresseDAO= new AdresseDAO();
					Adresse adresse =adresseDAO.getAdresse(id);
					utilisateur.setAdresse(adresse);
					
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
			return utilisateur;
}
//-----------------------------------------------------------------------------------------------
	@Override
	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		
		Utilisateur utilisateurAdded=null;
	try {
		String requete="INSERT INTO utilisateur (nom, prenom, age, email, modePass, telephone) VALUES (?,?,?,?,?,?)";
	    PreparedStatement ps=connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
	
	    ps.setString(1, utilisateur.getNom());
		ps.setString(2, utilisateur.getPrenom());	
		ps.setInt(3, utilisateur.getAge());
		ps.setString(4, utilisateur.getEmail());
		ps.setString(5, utilisateur.getModePass());
		ps.setString(6, utilisateur.getTelephone());
		ps.executeUpdate();
		
		utilisateurAdded = utilisateur;
	
	    ResultSet rs=ps.getGeneratedKeys();
		if (rs.next()) {
			utilisateurAdded.setId(rs.getInt(1));
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
	return utilisateurAdded;	
}	
//--------------------------------------------------------------------------------------------
	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		
		try {
			String requete = "UPDATE utilisateur SET nom ?, prenom =?, age =?, email=?, modePass=?, telephone=?, WHERE id = ?";
			PreparedStatement ps=connexion.prepareStatement(requete);
			
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());
			ps.setInt(3, utilisateur.getAge());
			ps.setString(4, utilisateur.getEmail());
			ps.setString(5, utilisateur.getModePass());
			ps.setString(6, utilisateur.getTelephone());
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

//--------------------------------------------------------------------------------------
	@Override
	public Utilisateur getUtilisateurByLogin(String login) {
		
		Utilisateur utilisateur=null;
		ResultSet rs=null;
		try {
			String requete= "SELECT * FROM utilisateur WHERE login=?";
			PreparedStatement ps=connexion.prepareStatement(requete);
			rs=ps.executeQuery();
			
					if (rs !=null && rs.next()) {
						utilisateur = new Utilisateur();
						utilisateur.setId(rs.getInt("id"));
						utilisateur.setNom(rs.getString("nom"));
						utilisateur.setPrenom(rs.getString("prenom"));
						utilisateur.setAge(rs.getInt("age"));
						utilisateur.setActif(rs.getBoolean("actif"));
						utilisateur.setEmail(rs.getString("email"));
						utilisateur.setModePass(rs.getString("modePass"));
						utilisateur.setTelephone(rs.getString("telephone"));
						utilisateur.setRole(rs.getString("role"));
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
			return utilisateur;
}
//-------------------------------------------------------------------------
	@Override
	public Utilisateur getUtilisateurByEmail(String email) {
		
		Utilisateur utilisateur=null;
		ResultSet rs=null;
		try {
			String requete= "SELECT * FROM utilisateur WHERE email=?";
			PreparedStatement ps=connexion.prepareStatement(requete);
			rs=ps.executeQuery();
			
					if (rs !=null && rs.next()) {
						utilisateur = new Utilisateur();
						utilisateur.setId(rs.getInt("id"));
						utilisateur.setNom(rs.getString("nom"));
						utilisateur.setPrenom(rs.getString("prenom"));
						utilisateur.setAge(rs.getInt("age"));
						utilisateur.setActif(rs.getBoolean("actif"));
						utilisateur.setEmail(rs.getString("email"));
						utilisateur.setModePass(rs.getString("modePass"));
						utilisateur.setTelephone(rs.getString("telephone"));
						utilisateur.setRole(rs.getString("role"));
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
			return utilisateur;
}
//---------------------------------------------------------------------------------------------
	@Override
	public void seDesinscrireUtilisateur(Integer id) {

		try {
			PreparedStatement ps=connexion.prepareStatement("DELETE from utilisateur where id=?");
			ps.setInt(1, id);
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
//--------------------------------------------------------------------------
	@SuppressWarnings("null")
	@Override
	public boolean seConnecter(String peseudo, String password) {
		
		 boolean status=true;
		 ResultSet rs=null;
		 Utilisateur utilisateur=null;
	        try{
	        String requete="select * from utilisateur where login=? and password=?";
	        PreparedStatement ps=connexion.prepareStatement(requete);
	        ps.setString(1,utilisateur.getLogin());
	        ps.setString(2,utilisateur.getModePass());
	        
	        rs=ps.executeQuery();
	        status=rs.next();
	        }

	        catch (SQLException e) {
	            throw new RuntimeException(e);
	        } finally {
	            if (connexion != null) {
	                try {
	                	connexion.close();
	                } catch (SQLException e) {}
	            }
	        }
	        return status;
	}
}
	
