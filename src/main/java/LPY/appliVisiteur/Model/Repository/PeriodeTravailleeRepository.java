package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface PeriodeTravailleeRepository extends CrudRepository<User, Integer> {
}
