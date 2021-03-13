package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Article;

import java.util.List;

public interface IArticleControl {

    List<Article> getArticles();

    Article addArticle(Article article);

    void removeArticle(Long id);

    void clear(Article article);


}
