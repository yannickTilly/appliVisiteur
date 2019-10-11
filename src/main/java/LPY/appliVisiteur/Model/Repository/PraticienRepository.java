package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Praticien;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PraticienRepository extends CrudRepository<Praticien, Integer> {
    Optional<Praticien> findById(Long id);
}
