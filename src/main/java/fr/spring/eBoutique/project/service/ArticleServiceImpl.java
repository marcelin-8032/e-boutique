package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService{

    @Override
    public List<Article> getArticles(Long idUtilisateur) {
        return null;
    }

    @Override
    public Article addArticle(Article article) {
        return null;
    }

    @Override
    public void removeArticle(Long id) {

    }

    @Override
    public void clear(Long idUtilisateur) {

    }
}
