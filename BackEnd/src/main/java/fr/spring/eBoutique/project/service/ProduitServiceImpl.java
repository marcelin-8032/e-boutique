package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Categorie;
import fr.spring.eBoutique.project.model.Produit;
import fr.spring.eBoutique.project.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitServiceImpl implements IProduitService {

    @Autowired
    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Transactional(readOnly = true)
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Produit> getProduitsByCategorie(Categorie categorie) {
        return produitRepository.findProductbyCategory(categorie);
    }

    @Transactional(readOnly = true)
    public List<Produit> gettoutedProduit() {
        List<Produit> produits = new ArrayList<>();
        produitRepository.findAll().forEach(produits::add);
        return produits;
    }

    public Produit addProduit(Produit produit) {
        produitRepository.save(produit);
        return produit;
    }

    public void updateProduit(Produit produit) {
        produitRepository.save(produit);
    }

    @Override
    public void removeProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
