package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Drug;
import org.springframework.data.repository.CrudRepository;

public interface DrugRepository extends CrudRepository<Drug, Integer> {
    Drug findOneById(Long id);
}
