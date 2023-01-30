package fr.eboutique.project.service;

import fr.eboutique.project.model.ArticleDePanier;
import fr.eboutique.project.model.Panier;

import java.util.List;

public interface IArticleDePanierService {

    List<ArticleDePanier> getArticles();

    ArticleDePanier addArticle(ArticleDePanier article);

    void removeArticle(Long id);

    void clear(Panier panier);


}
