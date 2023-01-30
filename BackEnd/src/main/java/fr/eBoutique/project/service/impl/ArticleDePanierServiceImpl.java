package fr.eboutique.project.service.impl;

import fr.eboutique.project.repository.ArticleRepository;
import fr.eboutique.project.model.ArticleDePanier;
import fr.eboutique.project.model.Panier;
import fr.eboutique.project.service.IArticleDePanierService;
import fr.eboutique.project.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleDePanierServiceImpl implements IArticleDePanierService {


    @Autowired
    private  IProduitService produitService;

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleDePanierServiceImpl(IProduitService produitService, ArticleRepository articleRepository) {
        this.produitService = produitService;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ArticleDePanier> getArticles() {
        List<ArticleDePanier> articles = new ArrayList<>();
        articleRepository.findAll().forEach(articles::add);
        return articles;
    }

    @Override
    public ArticleDePanier addArticle(ArticleDePanier article) {
        articleRepository.save(article);
        return article;
    }

    @Override
    public void removeArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void clear(Panier panier) {
        articleRepository.deleteAll();

    }
}
