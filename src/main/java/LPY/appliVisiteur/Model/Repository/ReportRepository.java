package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Report;
import LPY.appliVisiteur.Model.Entity.Region;
import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface ReportRepository extends CrudRepository<Report, Long> {
    Optional<Report> findById(Long id);
    Collection<Report> findByUser(User user);
    Report findOneByUserAndId(User user, long id);


    Report findOneByIdAndRegion(Long id, Region region);

    Collection<Report> findByUserAndRegion(User user, Region region);

}
