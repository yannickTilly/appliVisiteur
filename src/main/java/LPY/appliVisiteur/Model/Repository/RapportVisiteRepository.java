package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.RapportVisite;
import LPY.appliVisiteur.Model.Entity.Region;
import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface RapportVisiteRepository extends CrudRepository<RapportVisite, Long> {
    Optional<RapportVisite> findById(Long id);
    Collection<RapportVisite> findByUser(User user);
    RapportVisite findOneByUserAndId(User user, long id);


    RapportVisite findOneByIdAndRegion(Long id, Region region);

    Collection<RapportVisite> findByUserAndRegion(User user, Region region);

}
