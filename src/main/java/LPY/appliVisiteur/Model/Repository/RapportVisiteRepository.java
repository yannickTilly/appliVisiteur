package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.RapportVisite;
import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface RapportVisiteRepository extends CrudRepository<RapportVisite, Integer> {
    Optional<RapportVisite> findById(Long id);
    Collection<RapportVisite> findByUser(User user);
    RapportVisite findOneByUserAndId(User user, long id);
}
