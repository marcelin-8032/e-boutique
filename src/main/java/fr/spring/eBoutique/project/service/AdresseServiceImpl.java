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

    public AdresseServiceImpl(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }


    @Override
    public Adresse getAdresse(Long id) throws NotFoundException {
        Optional<Adresse> adresseOptional = adresseRepository.findById(id);
        if (!adresseOptional.isPresent()) {
            throw new NotFoundException("addrese not found for this id: " + id);
        }
        return adresseOptional.get();
    }

    @Override
    public Adresse addAdresse(Adresse adresse) {
       return adresseRepository.save(adresse);
    }

    @Override
    public void updateAdresse(Adresse adresse) {
        adresseRepository.save(adresse);
    }

    @Override
    public void removeAdresse(Long idUtilisateur) {
        adresseRepository.deleteById(idUtilisateur);
    }
}
