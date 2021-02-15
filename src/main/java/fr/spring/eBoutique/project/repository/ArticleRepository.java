package fr.spring.eBoutique.project.repository;

import fr.spring.eBoutique.project.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
