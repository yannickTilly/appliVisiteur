package LPY.appliVisiteur.Controller.Delegues;

import LPY.appliVisiteur.Model.Entity.RapportVisite;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.UserRepository;
import LPY.appliVisiteur.Model.View.Visiteur.RapportVisiteView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("delegues")
public class DelegueRapportVisiteController extends LPY.appliVisiteur.Controller.Visiteur.RapportVisiteController {
    @Autowired
    private UserRepository userRepository;

    @Override
    @RequestMapping(value = "rapportVisite/{id}", method = RequestMethod.GET)
    public String getRapportVisite(@PathVariable("id") Long id) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        RapportVisite rapportVisite = rapportVisiteRepository.findOneByIdAndRegion(id, this.getUser().getRegion());

        if (rapportVisite == null) {
            throw new RessouceNotFoundExeption("Aucun résulat");
        } else {
            return this.createResponse(rapportVisite, RapportVisiteView.RapportVisite.class);
        }
    }

    @Override
    @RequestMapping(value = "rapportVisites", method = RequestMethod.GET)
    public String getRapportVisites() throws UserNotFoundException, JsonProcessingException {
        Collection<RapportVisite> rapportVisites = this.getUser().getRegion().getRapportVisites();
        return this.createResponse(rapportVisites, RapportVisiteView.DelegueRapportVisite.class);
    }

    @RequestMapping(value = "user/{userId}/rapportVisites", method = RequestMethod.GET)
    public String getRapportVisites(@PathVariable("userId") Long id) throws UserNotFoundException, JsonProcessingException {
        User user = userRepository.findOneById(id);
        Collection<RapportVisite> rapportVisites = rapportVisiteRepository.findByUserAndRegion(user, this.getUser().getRegion());

        if (user != null)
        {
            return this.createResponse(rapportVisites, RapportVisiteView.RapportVisite.class);
        }else {
            throw new UserNotFoundException("Aucun utilisateur trouvé avec cet id");
        }
    }
}
