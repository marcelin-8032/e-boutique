package fr.spring.eBoutique.project.control;

import fr.spring.eBoutique.project.model.ArticleDePanier;
import fr.spring.eBoutique.project.service.IArticleDePanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ArticleDePanierControl {

    private final IArticleDePanierService articleService;

    @Autowired
    public ArticleDePanierControl(IArticleDePanierService articleService) {
        this.articleService = articleService;
    }



    @GetMapping(path = "{idUtilisateur}/articles")
    public List<ArticleDePanier> getArticles() {
        return articleService.getArticles();
    }


    @PostMapping
    public ArticleDePanier addArticle(@RequestBody @Valid ArticleDePanier article) {
        return articleService.addArticle(article);

    }

    @DeleteMapping("{idUtilisateur}")
    public void removeArticle(@PathVariable("idUtilisateur") Long idUtilisateur) {
        articleService.removeArticle(idUtilisateur);
    }

    public void clear(ArticleDePanier article) {
        articleService.clear(article);
    }

}
