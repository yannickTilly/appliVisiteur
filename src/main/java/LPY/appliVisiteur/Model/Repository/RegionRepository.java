package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Region;
import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<Region, Integer> {
}
