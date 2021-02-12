package fr.spring.eBoutique.project.dao;


import fr.spring.eBoutique.project.model.Commande;

import java.util.List;

public interface ICommandeDAO {

    Commande getCommande(Integer idUtilisatuer);

    Commande addCommande(Commande commande);

    List<Commande> getCommandes(Integer idUtilisatuer);

}
