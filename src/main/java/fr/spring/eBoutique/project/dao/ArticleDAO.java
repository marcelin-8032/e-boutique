package fr.spring.eBoutique.project.dao;


import fr.spring.eBoutique.project.BDD.DataSourceConnexion;
import fr.spring.eBoutique.project.model.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ArticleDAO implements IArticleDAO {

private Connection connexion= null;
	
	public ArticleDAO() {
		if (connexion == null) {
			try {
				connexion= DataSourceConnexion.getInstance().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//---------------------------------------------------------------------------	
	public List<Article> getArticles(Long idUtilisateur) {
	
		List<Article> listeLigneCom = null;
		ResultSet rs=null;
		
		try {
			String query = "SELECT * FROM article WHERE utilisateur_id1=?";
			Statement stm = connexion.createStatement();
			rs=stm.executeQuery(query);
			
			if (rs !=null) {
				listeLigneCom = new ArrayList<Article>();
				while (rs.next()) {
					Article article= new Article();
					article.setId((long) rs.getInt("id"));
					article.setQuantite(rs.getInt("quantite"));
					
					listeLigneCom.add(article);
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
		return listeLigneCom;
}

	@Override
	public List<Article> getArticles(Integer idUtilisateur) {
		return null;
	}

	//-------------------------------------------------------------------------
	@Override
	public Article addArticle(Article article) {

		Article articleadded=null;
		
			try {
				String requete="INSERT INTO article (quantite) VALUES (?)";
			    PreparedStatement ps=connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			    
			    ps.setInt(1, article.getQuantite());				
				ps.executeUpdate();
				articleadded = article;
			
			    ResultSet rs=ps.getGeneratedKeys();
				if (rs.next()) {
					articleadded.setId((long) rs.getInt(1));
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
			return articleadded;	
		}
//-------------------------------------------------------------------------
	@Override
	public void removeArticle(Long id) {
		
		try {			
			String requete="DELETE FROM article Where id= ?";
			PreparedStatement ps=connexion.prepareStatement(requete);
			ps.setInt(1, Math.toIntExact(id));
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
//-------------------------------------------------------------------------
	@Override
	public void clear(Long idUtilisateur) {
		try {			
			String requete="DELETE FROM article Where utilisateur_id= ?";
			PreparedStatement ps=connexion.prepareStatement(requete);
			ps.setInt(1, Math.toIntExact(idUtilisateur));
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
