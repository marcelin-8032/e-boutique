package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.LigneCommande;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeServiceImpl implements ILigneCommandeService{

    @Override
    public List<LigneCommande> getLignesCommande(Long idCommande) {
        return null;
    }

    @Override
    public LigneCommande addLigneCommande(LigneCommande ligneCommande) {
        return null;
    }
}
