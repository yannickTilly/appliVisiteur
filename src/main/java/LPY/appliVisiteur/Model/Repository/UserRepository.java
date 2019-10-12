package LPY.appliVisiteur.Model.Repository;

import LPY.appliVisiteur.Model.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByLogin(String login);
    Optional<User> findById(long id);
}