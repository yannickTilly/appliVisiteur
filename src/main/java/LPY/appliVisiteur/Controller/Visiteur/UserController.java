package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.RapportVisiteRepository;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController extends BaseController
{
    @Autowired
    private RapportVisiteRepository rapportVisiteRepository;

    @RequestMapping("/user")
    public String getVisiteur() throws UserNotFoundException, JsonProcessingException {
        return this.createResponse(this.getUser(), UserView.user.class);
    }
}