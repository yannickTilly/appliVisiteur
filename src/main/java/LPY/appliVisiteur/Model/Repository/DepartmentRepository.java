package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Department findOneById(Long id);
}
