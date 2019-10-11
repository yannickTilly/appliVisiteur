package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Secteur;
import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface SecteurRepository extends CrudRepository<Secteur, Integer> {
}
