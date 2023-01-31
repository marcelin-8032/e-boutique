package fr.eboutique.project.service.impl;

import fr.eboutique.project.model.Panier;
import fr.eboutique.project.repository.PanierRepository;
import fr.eboutique.project.service.IPanierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class PanierServiceImpl implements IPanierService {

    private final PanierRepository panierRepository;
    private final CommandeServiceImpl commandeService;

    public PanierServiceImpl(PanierRepository panierRepository, CommandeServiceImpl commandeService) {
        this.panierRepository = panierRepository;
        this.commandeService = commandeService;
    }

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
