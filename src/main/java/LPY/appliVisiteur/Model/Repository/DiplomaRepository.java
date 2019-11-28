package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Diploma;
import org.springframework.data.repository.CrudRepository;

public interface DiplomaRepository extends CrudRepository<Diploma, Integer> {
    Diploma findOneById(Long id);
}
