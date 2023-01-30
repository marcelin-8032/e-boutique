package fr.eboutique.project.service.impl;

import fr.eboutique.project.model.Adresse;
import fr.eboutique.project.repository.AdresseRepository;
import fr.eboutique.project.service.IAdresseService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdresseServiceImpl implements IAdresseService {

    @Autowired
    private AdresseRepository adresseRepository;

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
