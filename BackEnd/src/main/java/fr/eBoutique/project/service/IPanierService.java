package fr.eboutique.project.service;

import fr.eboutique.project.model.Panier;

import java.io.IOException;

public interface IPanierService {

    void addPanier(Panier panier);

    Panier getPanierById(Long panierId);

    Panier ValidateClient(Long panierId) throws IOException;
}
