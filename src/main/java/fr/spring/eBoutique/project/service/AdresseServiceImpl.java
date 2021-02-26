package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Adresse;
import fr.spring.eBoutique.project.repository.AdresseRepository;
import fr.spring.eBoutique.project.repository.UtilisateurRepositoy;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AdresseServiceImpl implements IAdresseService {

    @Autowired
    private final AdresseRepository adresseRepository;
    private final UtilisateurRepositoy utilisateurRepositoy;

    public AdresseServiceImpl(AdresseRepository adresseRepository, UtilisateurRepositoy utilisateurRepositoy) {
        this.adresseRepository = adresseRepository;
        this.utilisateurRepositoy = utilisateurRepositoy;
    }


    //--------------------------------
    @Override
    public Adresse getAdresse(Long idUtilisateur) throws NotFoundException {
        Optional<Adresse> adresseOptional = adresseRepository.findById(idUtilisateur);

        if (!adresseOptional.isPresent()) {
            throw new NotFoundException("addrese not found for this id: " + idUtilisateur);
        }

        return adresseOptional.get();
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
