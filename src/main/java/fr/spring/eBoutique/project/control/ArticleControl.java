package fr.spring.eBoutique.project.control;

import fr.spring.eBoutique.project.dao.ArticleDAOImpl;
import fr.spring.eBoutique.project.model.Article;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class ArticleControl implements IArticleControl {

	private ArticleDAOImpl aDao = new ArticleDAOImpl();
	
	 public ArticleControl() {
		
	}
	
	@Override
	public List<Article> getArticles(Long idUtilisateur) {
		
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
	public void removeArticle(Long id) {
		
		try {
			aDao.removeArticle(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void clear(Long idUtilisateur) {
		
			try {
				aDao.clear(idUtilisateur);
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

}
