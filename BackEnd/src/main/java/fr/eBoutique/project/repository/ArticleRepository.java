package fr.eboutique.project.repository;

import fr.eboutique.project.model.ArticleDePanier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<ArticleDePanier, Long> {

}
