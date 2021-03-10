package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Categorie;
import fr.spring.eBoutique.project.model.Produit;
import fr.spring.eBoutique.project.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements IProduitService {


    @Autowired
    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }


    @Override
    public Optional<Produit> getProduit(Long id) {
        return produitRepository.findById(id);
    }

    @Override
    public List<Produit> getProduitsByCategorie(Categorie categorie) {
        return produitRepository.findProductbyCategory(categorie);

    }

    @Override
    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public void updateProduit(Produit produit) {
        produitRepository.save(produit);
    }

    @Override
    public void removeProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
