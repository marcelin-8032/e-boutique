package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Adresse;
import javassist.NotFoundException;

public interface IAdresseService {

    Adresse getAdresse(Long id) throws NotFoundException;

    Adresse addAdresse(Adresse adresse);

    void updateAdresse(Adresse adresse);

    void removeAdresse(Long id);

}
