package fr.spring.eBoutique.project.dao;


import fr.spring.eBoutique.project.BDD.DataSourceConnexion;
import fr.spring.eBoutique.project.model.Adresse;

import java.sql.*;

public class AdresseDAO implements IAdresseDAO {

private Connection connexion= null;
	
	public AdresseDAO() {
		if (connexion == null) {
			try {
				connexion= DataSourceConnexion.getInstance().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//--------------------------------------------------------------------	

	@Override
	public Adresse getAdresse(Long idUtilisateur) {

		Adresse adresse=null;
		try {
			String requete ="SELECT * FROM adresse WHERE utilisateur_id= ?";
			PreparedStatement ps=connexion.prepareStatement(requete);
			ps.setLong(1, idUtilisateur);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				adresse = new Adresse();
				adresse.setId(idUtilisateur);
				adresse.setNumero(rs.getInt("numero"));
				adresse.setRue(rs.getString("rue"));
				adresse.setVille(rs.getString("ville"));
				adresse.setCodePostal(rs.getInt("codePostal"));
			}
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (connexion!=null) {
					connexion.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		return adresse;
	}
//--------------------------------------------------------------------------------------------
	@Override
	public Adresse addAdresse(Adresse adresse, Integer idUtilisateur) {
		
		try {
			String requete = "INSERT INTO adresse(numero, rue, ville, code_Postal) VALUES (?,?,?,?)";
			PreparedStatement ps=connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, adresse.getNumero());
			ps.setString(2, adresse.getRue());
			ps.setString(3, adresse.getVille());
			ps.setInt(4, adresse.getCodePostal());
			
			ps.executeUpdate();
			
			ResultSet rs =ps.getGeneratedKeys();
			if (rs.next()) {
				adresse.setId(rs.getLong(1));
			} 

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
		return adresse;
	}
//-------------------------------------------------------------------------------------------
	@Override
	public void updateAdresse(Adresse adresse, Integer idUtilisateur) {
		
		try {
			String requete = "UPDATE adresse SET numero ?, rue =?, ville =? codePostal=? WHERE utilisateur_id=? ";
			PreparedStatement ps=connexion.prepareStatement(requete);
			ps.setInt(1, adresse.getNumero());
			ps.setString(2, adresse.getRue());
			ps.setString(3, adresse.getVille());
			ps.setInt(4, adresse.getCodePostal());
			ps.setInt(5, idUtilisateur);
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
//-----------------------------------------------------------------------------------------------
	@Override
	public void removeAdresse(Integer idUtilisateur) {

		try {
			String requete="DELETE FROM adresse Where utilisateur_id=?";
			PreparedStatement ps=connexion.prepareStatement(requete);
			ps.setInt(1, idUtilisateur);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			
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
	
	
	
	
