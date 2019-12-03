package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.WorkedTime;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.WorkedTimeRepository;
import LPY.appliVisiteur.Model.View.Visiteur.WorkedTimeView;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView(WorkedTimeView.PeriodeTravaille.class)
    public WorkedTime getWorkedTime(@PathVariable("id") Long id) throws UserNotFoundException, JsonProcessingException, RessouceNotFoundExeption {
        WorkedTime workedTime = workedTimeRepository.findByIdAndUser(id, this.getUser());
        if (workedTime == null)
        {
            throw new RessouceNotFoundExeption("workedTime not found");
        }
        else
        {
            return workedTime;
        }
    }

    @RequestMapping(value = "workedTimes", method = RequestMethod.GET)
    @JsonView(WorkedTimeView.PeriodeTravaille.class)
    public Collection<WorkedTime> getWorkedTimes() throws UserNotFoundException, JsonProcessingException {
        User user = this.getUser();
        Collection<WorkedTime> workedTimes = workedTimeRepository.findByUser(user);
        return workedTimes;
    }
}
