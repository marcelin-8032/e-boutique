package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.ArticleDePanier;
import fr.spring.eBoutique.project.model.Panier;

import java.util.List;

public interface IArticleDePanierService {

    List<ArticleDePanier> getArticles();

    ArticleDePanier addArticle(ArticleDePanier article);

    void removeArticle(Long id);

    void clear(Panier panier);


}
