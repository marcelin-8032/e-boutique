package fr.eboutique.project.service.impl;

import fr.eboutique.project.model.Utilisateur;
import fr.eboutique.project.repository.UtilisateurRepositoy;
import fr.eboutique.project.service.IUtilisateurService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

    private final UtilisateurRepositoy utilisateurRepositoy;

    public UtilisateurServiceImpl(UtilisateurRepositoy utilisateurRepositoy) {
        this.utilisateurRepositoy = utilisateurRepositoy;
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepositoy.save(utilisateur);
    }


    @Transactional(readOnly = true)
    @Override
    public Utilisateur getUtilisateurById(Long id) {

        Optional<Utilisateur> utilisateurOptional = utilisateurRepositoy.findById(id);
        if (!utilisateurOptional.isPresent()) {
            throw new RuntimeException("Utilisatuer n'a pas trouvé");
        }
        return
                utilisateurOptional.get();
    }

    @Override
    public Utilisateur getUtilisateurByEmail(String email) {
        return utilisateurRepositoy.findUtilisatuerByEmail(email);
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        utilisateurRepositoy.save(utilisateur);
    }

    @Override
    public void removeUtilisateur(Long id) {
        utilisateurRepositoy.deleteById(id);
    }

}
