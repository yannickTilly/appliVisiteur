package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.RapportVisite;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.RapportVisiteRepository;
import LPY.appliVisiteur.Model.View.Visiteur.RapportVisiteView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class RapportVisiteController extends BaseController {
    @Autowired
    private RapportVisiteRepository rapportVisiteRepository;

    @RequestMapping(value = "rapportVisite/{id}", method = RequestMethod.GET)
    public String getRapportVisite(@PathVariable("id") Long id) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        RapportVisite rapportVisite = rapportVisiteRepository.findOneByUserAndId(this.getUser(),id);
        if (rapportVisite == null)
        {
            throw new RessouceNotFoundExeption("rapport visite not found");
        }
        else
        {
            return this.createResponse(rapportVisite, RapportVisiteView.rapportVisite.class);
        }

    }

    @RequestMapping(value = "rapportVisites", method = RequestMethod.GET)
    public String getRapportVisites() throws UserNotFoundException, JsonProcessingException {
        User user = this.getUser();
        Collection<RapportVisite> rapportVisites = rapportVisiteRepository.findByUser(user);
        return this.createResponse(rapportVisites, RapportVisiteView.rapportVisite.class);
    }
}
