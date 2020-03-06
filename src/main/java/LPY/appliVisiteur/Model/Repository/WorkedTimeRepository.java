package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.WorkedTime;
import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface WorkedTimeRepository extends CrudRepository<WorkedTime, Integer> {
    Optional<WorkedTime> findById(long id);
    Collection<WorkedTime>findByUser(User user);
    WorkedTime findByIdAndUser(long id, User user);


}

