package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Repository.RapportVisiteRepository;
import LPY.appliVisiteur.Service.Authentificator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class UserController extends BaseController
{
    @Autowired
    private RapportVisiteRepository rapportVisiteRepository;

    @RequestMapping("/user")
    public Optional<User> getVisiteur()
    {
        return this.getUser();
    }
}