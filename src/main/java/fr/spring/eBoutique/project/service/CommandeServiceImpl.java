package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.CartePaiement;
import fr.spring.eBoutique.project.model.Commande;
import fr.spring.eBoutique.project.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements ICommandeService {

    @Autowired
    private final CommandeRepository commandeRepository;

    @Autowired
    private final ICartePaiementService cartePaiementService;

    public CommandeServiceImpl(CommandeRepository commandeRepository, ICartePaiementService cartePaiementService) {
        this.commandeRepository = commandeRepository;
        this.cartePaiementService = cartePaiementService;
    }

    @Override
    public Commande getCommande(Long idCommand) {
        Optional<Commande> commande = commandeRepository.findById(idCommand);
        if (!commande.isPresent()) {
            throw new RuntimeException("Commande n'a pas trouvé");
        }
        return commande.get();
    }

    @Override
    public Commande addCommande(Commande commande) {

        CartePaiement cartePaiement = commande.getCartePaiement();
        Commande commandeAncien = commandeRepository.getClientOrderBycart(cartePaiement);

        if (commandeAncien != null) {
            commandeAncien.setClient(cartePaiement.getClient());
            commandeAncien.setAdresse(cartePaiement.getClient().getAdresse());
            commandeRepository.save(commandeAncien);
            return commandeAncien;
        } else {
            commandeAncien.setClient(cartePaiement.getClient());
            commandeAncien.setAdresse(cartePaiement.getClient().getAdresse());
            commandeRepository.save(commande);
            return commande;
        }

    }


    @Transactional(readOnly = true)
    @Override
    public List<Commande> getAllCommandes() {
        return (List<Commande>) commandeRepository.findAll();
    }

    @Override
    public void removeCommand(Long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public void updateCommande(Commande commande) {
        commandeRepository.save(commande);
    }

}
