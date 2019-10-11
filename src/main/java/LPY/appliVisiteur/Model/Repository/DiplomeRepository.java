package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Diplome;
import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface DiplomeRepository extends CrudRepository<Diplome, Integer> {
}
