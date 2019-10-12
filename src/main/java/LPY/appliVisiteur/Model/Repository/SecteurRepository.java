package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Secteur;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SecteurRepository extends CrudRepository<Secteur, Integer>
{
    Optional<Secteur> findById(Long id);
}
