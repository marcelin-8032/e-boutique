package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Adresse;
import fr.spring.eBoutique.project.repository.AdresseRepository;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AdresseServiceImpl implements IAdresseService {

    @Autowired
    private final AdresseRepository adresseRepository;
    private final Adresse adresse;

    public AdresseServiceImpl(AdresseRepository adresseRepository, Adresse adresse) {
        this.adresseRepository = adresseRepository;
        this.adresse = adresse;
    }

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
        adresse.setId(idUtilisateur);

        return null;
    }

    @Override
    public void updateAdresseById(Adresse adresse, Long idUtilisateur) {
        adresse.setId(idUtilisateur);
        adresseRepository.save(adresse);
    }

    @Override
    public void removeAdresse(Long idUtilisateur) {
        adresseRepository.deleteById(idUtilisateur);
    }
}
