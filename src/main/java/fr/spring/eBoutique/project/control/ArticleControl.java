package fr.spring.eBoutique.project.control;

import fr.spring.eBoutique.project.model.Article;
import fr.spring.eBoutique.project.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ArticleControl implements IArticleControl {

	private final IArticleService articleService;

	@Autowired
	public ArticleControl(IArticleService articleService) {
		this.articleService = articleService;
	}


	@Override
	@GetMapping(path = "{idUtilisateur}/articles")
	public List<Article> getArticles(@PathVariable("idUtilisateur") Long idUtilisateur) {
			return articleService.getArticles(idUtilisateur);
	}

	@Override
	@PostMapping
	public Article addArticle(@RequestBody @Valid Article article) {
			return articleService.addArticle(article);

	}

	@Override
	@DeleteMapping("{idUtilisateur}")
	public void removeArticle(@PathVariable("idUtilisateur") Long idUtilisateur) {
			articleService.removeArticle(idUtilisateur);
	}

	@Override
	public void clear(Long idUtilisateur) {
				articleService.clear(idUtilisateur);
	}

}
