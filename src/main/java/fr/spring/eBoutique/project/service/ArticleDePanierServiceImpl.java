package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.ArticleDePanier;
import fr.spring.eBoutique.project.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleDePanierServiceImpl implements IArticleDePanierService {


    @Autowired
    private final IProduitService produitService;

    @Autowired
    private final ArticleRepository articleRepository;

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
    public void clear(ArticleDePanier article) {
        articleRepository.deleteAll();

    }
}
