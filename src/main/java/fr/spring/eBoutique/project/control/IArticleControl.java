package fr.spring.eBoutique.project.control;

import fr.eboutique.project.entity.Article;

import java.util.List;

public interface IArticleControl {

	public List<Article> getArticles(Integer idUtilisateur);
	public Article addArticle(Article article);
	public void removeArticle(Integer id);
	public void clear (Integer idUtilisateur);
	

}
