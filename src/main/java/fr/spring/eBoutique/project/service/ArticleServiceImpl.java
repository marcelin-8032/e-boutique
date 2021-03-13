package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Article;
import fr.spring.eBoutique.project.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {


    @Autowired
    private final IProduitService produitService;

    @Autowired
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(IProduitService produitService, ArticleRepository articleRepository) {
        this.produitService = produitService;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getArticles() {
        List<Article> articles = new ArrayList<>();
        articleRepository.findAll().forEach(articles::add);
        return articles;
    }

    @Override
    public Article addArticle(Article article) {
        articleRepository.save(article);
        return article;
    }

    @Override
    public void removeArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void clear(Article article) {
        articleRepository.deleteAll();

    }
}
