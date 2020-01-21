package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.BaseController.BaseController;
import LPY.appliVisiteur.Controller.BaseController.WorkedTimeController;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Entity.WorkedTime;
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

import javax.annotation.security.RolesAllowed;
import java.util.Collection;

@RestController
@RequestMapping("visitor")
@RolesAllowed("ROLE_VISITOR")
public class VisitorWorkedTimeController extends WorkedTimeController {
    @Autowired
    private WorkedTimeRepository workedTimeRepository;

    @RequestMapping(value = "workedTime/{id}", method = RequestMethod.GET)
    @JsonView(WorkedTimeView.PeriodeTravaille.class)
    public WorkedTime getWorkedTime(@PathVariable("id") Long id) throws UserNotFoundException, RessouceNotFoundExeption {
        return super.getWorkedTime(id);
    }

    @RequestMapping(value = "workedTimes", method = RequestMethod.GET)
    @JsonView(WorkedTimeView.PeriodeTravaille.class)
    public Collection<WorkedTime> getWorkedTimes() throws UserNotFoundException{
        return super.getWorkedTimes();
    }
}
