package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RegionRepository extends CrudRepository<Region, Integer> {
    Region findOneById(Long id);
}
