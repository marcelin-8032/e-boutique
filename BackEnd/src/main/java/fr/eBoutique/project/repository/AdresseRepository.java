package fr.eboutique.project.repository;

import fr.eboutique.project.model.Adresse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends CrudRepository<Adresse,Long > {


}
