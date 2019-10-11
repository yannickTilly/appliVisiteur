package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Medicament;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MedicamentRepository extends CrudRepository<Medicament, Integer> {
    Optional<Medicament> findById(Long id);
}
