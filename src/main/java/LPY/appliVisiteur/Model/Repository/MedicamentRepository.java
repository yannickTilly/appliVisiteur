package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Medicament;
import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface MedicamentRepository extends CrudRepository<Medicament, Integer> {
}
