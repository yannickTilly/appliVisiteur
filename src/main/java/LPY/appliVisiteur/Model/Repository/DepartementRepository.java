package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Departement;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartementRepository extends CrudRepository<Departement, Integer> {
    Optional<Departement> findById(Long id);
}
