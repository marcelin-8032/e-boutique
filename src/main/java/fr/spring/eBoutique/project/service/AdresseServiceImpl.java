package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Adresse;
import fr.spring.eBoutique.project.repository.AdresseRepository;
import org.springframework.stereotype.Service;

@Service
public class AdresseServiceImpl implements IAdresseService {

    private AdresseRepository adresseRepository;

    @Override
    public Adresse getAdresse(Long idUtilisateur) {
        return null;
    }

    @Override
    public Adresse addAdresse(Adresse adresse, Long idUtilisateur) {
        return null;
    }

    @Override
    public void updateAdresse(Adresse adresse, Long idUtilisateur) {

    }

    @Override
    public void removeAdresse(Long idUtilisateur) {

    }
}
