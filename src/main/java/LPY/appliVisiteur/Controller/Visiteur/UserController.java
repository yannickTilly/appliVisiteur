package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Repository.RapportVisiteRepository;
import LPY.appliVisiteur.Service.Authentificator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController
{
    @Autowired
    private RapportVisiteRepository rapportVisiteRepository;

    @Autowired
    Authentificator authentificator;

    @RequestMapping("/user")
    public User getVisiteur()
    {
        return authentificator.getUser();
    }
}