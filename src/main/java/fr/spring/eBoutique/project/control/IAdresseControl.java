package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Adresse;

public interface IAdresseControl {

    Adresse getAdresse(Long idUtilisateur);

    Adresse addAdresse(Adresse adresse, Long idUtilisateur);

    void updateAdresse(Adresse adresse, Long idUtilisateur);

    void removeAdresse(Long idUtilisateur);


}
