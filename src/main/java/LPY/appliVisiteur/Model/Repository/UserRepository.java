package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findById(int id);
    User findByLogin(String login);
}