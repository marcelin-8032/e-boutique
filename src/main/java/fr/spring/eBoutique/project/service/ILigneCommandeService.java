package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.LigneCommande;

import java.util.List;

public interface ILigneCommandeService {


    List<LigneCommande> getLignesCommande(Long idCommande);

    LigneCommande addLigneCommande(LigneCommande ligneCommande);


}
