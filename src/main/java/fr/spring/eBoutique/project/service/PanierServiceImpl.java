package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Panier;
import fr.spring.eBoutique.project.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public class PanierServiceImpl implements IPanierService {

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    CommandeServiceImpl commandeService;

    @Transactional()
    @Override
    public void addPanier(Panier panier) {
        panierRepository.save(panier);
    }


    @Transactional(readOnly = true)
    @Override
    public Panier getPanierById(Long panierId) {

        return panierRepository.findById(panierId).orElse(null);
    }

    @Override
    public Panier ValidateClient(Long panierId) throws IOException {

        Panier panier = getPanierById(panierId);

        if (panier == null || panier.getArticleDePaniers().size() == 0) {
            throw new IOException(panierId + "");
        }
        // updatePanier(panier);

        return getPanierById(panierId);
    }


}
