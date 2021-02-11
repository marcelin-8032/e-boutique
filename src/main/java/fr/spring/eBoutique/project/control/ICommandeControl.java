package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Commande;

import java.util.List;

public interface ICommandeControl {

    Commande getCommande(Integer idUtilisatuer);

    Commande addCommande(Commande commande);

    List<Commande> getCommandes(Integer idUtilisatuer);


}
