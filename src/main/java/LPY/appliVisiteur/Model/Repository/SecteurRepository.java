package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Sector;
import org.springframework.data.repository.CrudRepository;

public interface SecteurRepository extends CrudRepository<Sector, Integer>
{
    Sector findOneById(Long id);
}
