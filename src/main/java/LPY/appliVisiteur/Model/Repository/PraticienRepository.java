package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Praticien;
import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface PraticienRepository extends CrudRepository<Praticien, Integer> {
}
