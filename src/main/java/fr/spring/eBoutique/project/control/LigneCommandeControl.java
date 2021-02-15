package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.LigneCommande;
import fr.spring.eBoutique.project.service.ILigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class LigneCommandeControl implements ILigneCommandeControl {

	private final ILigneCommandeService ligneCommandeService;

	@Autowired
	public LigneCommandeControl(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	@Override
	@GetMapping("{idUtilisatuer}/LigneCommande")
	public List<LigneCommande> getLignesCommande(@PathVariable("idCommande") Long idCommande) {
		return ligneCommandeService.getLignesCommande(idCommande);
	}

	@Override
	@PostMapping
	public LigneCommande addLigneCommande(@RequestBody LigneCommande ligneCommande) {
		return ligneCommandeService.addLigneCommande(ligneCommande);
	}

}
