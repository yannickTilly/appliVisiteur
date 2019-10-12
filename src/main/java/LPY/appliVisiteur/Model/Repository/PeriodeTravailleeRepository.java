package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.PeriodeTravaillee;
import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface PeriodeTravailleeRepository extends CrudRepository<PeriodeTravaillee, Integer> {
    Optional<PeriodeTravaillee> findById(long id);
    Collection<PeriodeTravaillee>findByUser(User user);
    PeriodeTravaillee findByIdAndUser(long id, User user);
}
