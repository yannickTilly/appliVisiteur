package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Departement;
import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface DepartementRepository extends CrudRepository<Departement, Integer> {
}
