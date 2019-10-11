package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.RapportVisite;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RapportVisiteRepository extends CrudRepository<RapportVisite, Integer> {
    Optional<RapportVisite> findById(Integer id);
}
