package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Adresse;
import javassist.NotFoundException;

public interface IAdresseControl {

    Adresse getAdresse(Long idUtilisateur) throws NotFoundException;

    Adresse addAdresse(Adresse adresse);

    void updateAdresse(Adresse adresse);

    void removeAdresse(Long idUtilisateur);


}
