package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Produit;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitServiceImpl implements IProduitService{
    @Override
    public Produit getProduit(Long id) {
        return null;
    }

    @Override
    public List<Produit> getProduitsByCategorie(String categorie) {
        return null;
    }

    @Override
    public Produit addProduit(Produit produit) {
        return null;
    }

    @Override
    public void updateProduit(Produit produit) {

    }

    @Override
    public void removeProduit(Long id) {

    }
}
