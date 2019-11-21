package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.WorkedTime;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.RessourceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.WorkedTimeRepository;
import LPY.appliVisiteur.Model.View.Visiteur.WorkedTimeView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("visitor")
public class VisitorWorkedTimeController extends BaseController {
    @Autowired
    private WorkedTimeRepository workedTimeRepository;

    @RequestMapping(value = "workedTime/{id}", method = RequestMethod.GET)
    public String getWorkedTime(@PathVariable("id") Long id) throws UserNotFoundException, JsonProcessingException, RessourceNotFoundExeption {
        WorkedTime workedTime = workedTimeRepository.findByIdAndUser(id, this.getUserEntity());
        if (workedTime == null)
        {
            throw new RessourceNotFoundExeption("workedTime not found");
        }
        else
        {
            return this.createResponse(workedTime, WorkedTimeView.PeriodeTravaille.class);
        }
    }

    @RequestMapping(value = "workedTimes", method = RequestMethod.GET)
    public String getWorkedTimes() throws UserNotFoundException, JsonProcessingException {
        User user = this.getUserEntity();
        Collection<WorkedTime> workedTimes = workedTimeRepository.findByUser(user);
        return this.createResponse(workedTimes, WorkedTimeView.PeriodeTravaille.class);
    }
}
