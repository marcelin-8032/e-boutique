package fr.spring.eBoutique.project.repository;

import fr.spring.eBoutique.project.model.ArticleDePanier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<ArticleDePanier, Long> {

}
