package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Adresse;
import javassist.NotFoundException;

public interface IAdresseControl {

    Adresse getAdresse(Long idUtilisateur) throws NotFoundException;

    Adresse addAdresse(Adresse adresse, Long idUtilisateur);

    void updateAdresse(Adresse adresse, Long idUtilisateur);

    void removeAdresse(Long idUtilisateur);


}
