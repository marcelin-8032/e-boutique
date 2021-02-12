package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Adresse;

public interface IAdresseService {

    Adresse getAdresse(Long idUtilisateur);

    Adresse addAdresse(Adresse adresse, Long idUtilisateur);

    void updateAdresse(Adresse adresse,Long idUtilisateur);

    void removeAdresse(Long idUtilisateur);
}
