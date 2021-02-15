package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Commande;

import java.util.List;

public interface ICommandeService {
    Commande getCommande(Long idUtilisatuer);

    Commande addCommande(Commande commande);

    List<Commande> getAllCommandes(Long idUtilisatuer);




}
