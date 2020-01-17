package LPY.appliVisiteur.Controller.BaseController;

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

public class WorkedTimeController extends BaseController {
    @Autowired
    private WorkedTimeRepository workedTimeRepository;

    public WorkedTime getWorkedTime(Long id) throws UserNotFoundException, RessouceNotFoundExeption {
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

    public Collection<WorkedTime> getWorkedTimes() throws UserNotFoundException{
        User user = this.getUser();
        Collection<WorkedTime> workedTimes = workedTimeRepository.findByUser(user);
        return workedTimes;
    }
}
