package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.PeriodeTravaillee;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.PeriodeTravailleeRepository;
import LPY.appliVisiteur.Model.View.Visiteur.PeriodeTravailleeView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PeriodeTravailleeController extends BaseController {
    @Autowired
    private PeriodeTravailleeRepository periodeTravailleeRepository;

    @RequestMapping(value = "periodeTravaillee/{id}", method = RequestMethod.GET)
    public String getDepartement(@PathVariable("id") Long id) throws UserNotFoundException, JsonProcessingException, RessouceNotFoundExeption {
        PeriodeTravaillee periodeTravaillee = periodeTravailleeRepository.findByIdAndUser(id, this.getUser());
        if (periodeTravaillee == null)
        {
            throw new RessouceNotFoundExeption("periodeTravaille not found");
        }
        else
        {
            return this.createResponse(periodeTravaillee, PeriodeTravailleeView.periodeTravaille.class);
        }
    }

    @RequestMapping(value = "periodeTravaillees", method = RequestMethod.GET)
    public String getPeriodeTravaillees() throws UserNotFoundException, JsonProcessingException {
        User user = this.getUser();
        Collection<PeriodeTravaillee> periodeTravaillees = periodeTravailleeRepository.findByUser(user);
        return this.createResponse(periodeTravaillees, PeriodeTravailleeView.periodeTravaille.class);
    }
}
