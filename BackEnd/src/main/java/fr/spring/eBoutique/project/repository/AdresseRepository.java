package fr.spring.eBoutique.project.repository;

import fr.spring.eBoutique.project.model.Adresse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends CrudRepository<Adresse,Long > {


}
