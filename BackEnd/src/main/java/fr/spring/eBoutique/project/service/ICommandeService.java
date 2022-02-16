package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Commande;

import java.util.List;

public interface ICommandeService {


    Commande getCommande(Long id);

    Commande addCommande(Commande commande);

    List<Commande> getAllCommandes();

    void removeCommand(Long id);

    void updateCommande(Commande commande);


}
