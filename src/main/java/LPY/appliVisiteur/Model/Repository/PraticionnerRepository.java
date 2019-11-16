package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Pratitionner;
import org.springframework.data.repository.CrudRepository;

public interface PraticionnerRepository extends CrudRepository<Pratitionner, Integer> {
    Pratitionner findOneById(Long id);
}
