package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.PresentationMedicament;
import org.springframework.data.repository.CrudRepository;

public interface PresentationMedicamentRepository extends CrudRepository<PresentationMedicament, Integer> {
    PresentationMedicament findOneById(Long id);
}
