package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Article;

import java.util.List;

public interface IArticleService {

    List<Article> getArticles(Long idUtilisateur);

    Article addArticle(Article article);

    void removeArticle(Long id);

    void clear(Long idUtilisateur);


}
