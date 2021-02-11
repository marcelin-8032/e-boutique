package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Adresse;

public interface IAdresseControl {

    Adresse getAdresse(Long idUtilisateur);

    Adresse addAdresse(Adresse adresse, Integer idUtilisateur);

    void updateAdresse(Adresse adresse, Integer idUtilisateur);

    void removeAdresse(Integer idUtilisateur);


}
