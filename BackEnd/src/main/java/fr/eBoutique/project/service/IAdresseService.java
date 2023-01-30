package fr.eboutique.project.service;

import fr.eboutique.project.model.Adresse;
import javassist.NotFoundException;

public interface IAdresseService {

    Adresse getAdresse(Long id) throws NotFoundException;

    Adresse addAdresse(Adresse adresse);

    void updateAdresse(Adresse adresse);

    void removeAdresse(Long id);

}
