package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Diplome;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DiplomeRepository extends CrudRepository<Diplome, Integer> {
    Diplome findOneById(Long id);
}
