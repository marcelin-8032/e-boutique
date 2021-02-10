package fr.spring.eBoutique.project.control;

import fr.eboutique.project.dao.ArticleDAO;
import fr.eboutique.project.entity.Article;

import java.util.List;

public class ArticleControl implements IArticleControl {

	private ArticleDAO aDao = new ArticleDAO();
	
	 public ArticleControl() {
		
	}
	
	@Override
	public List<Article> getArticles(Integer idUtilisateur) {
		
		try {
			return aDao.getArticles(idUtilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Article addArticle(Article article) {
		
		try {
			return aDao.addArticle(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void removeArticle(Integer id) {
		
		try {
			aDao.removeArticle(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void clear(Integer idUtilisateur) {
		
			try {
				aDao.clear(idUtilisateur);
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

}
