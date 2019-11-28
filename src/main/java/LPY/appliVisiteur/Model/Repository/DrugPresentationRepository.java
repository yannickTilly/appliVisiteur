package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.DrugPresentation;
import org.springframework.data.repository.CrudRepository;

public interface DrugPresentationRepository extends CrudRepository<DrugPresentation, Integer> {
    DrugPresentation findOneById(Long id);
}
