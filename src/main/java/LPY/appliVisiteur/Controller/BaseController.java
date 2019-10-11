package LPY.appliVisiteur.Controller;

import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Service.Authentificator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BaseController {
    @Autowired
    Authentificator authentificator;

    public Authentificator getAuthentificator() {
        return authentificator;
    }

    public Optional<User> getUser()
    {
        return this.getAuthentificator().getUser();
    }
}
