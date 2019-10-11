package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.PeriodeTravaillee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PeriodeTravailleeRepository extends CrudRepository<PeriodeTravaillee, Integer> {
    Optional<PeriodeTravaillee> findById(Integer id);
}
