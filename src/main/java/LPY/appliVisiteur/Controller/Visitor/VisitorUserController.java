package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.BaseController.BaseController;
import LPY.appliVisiteur.Controller.BaseController.UserController;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.AccessDeniedException;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.ReportRepository;
import LPY.appliVisiteur.Model.Repository.UserRepository;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.VisiteurBody;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("visitor")
@RolesAllowed("ROLE_VISITOR")
public class VisitorUserController extends UserController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReportRepository reportRepository;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @JsonView(UserView.User.class)
    public User getVisitor() throws UserNotFoundException {
        return super.getVisitor();

    }

    @RequestMapping(value = "/user", method = RequestMethod.PATCH)
    @JsonView(UserView.User.class)
    public User patchVisitor(@RequestBody VisiteurBody visiteurBody) throws UserNotFoundException, AccessDeniedException {
        User user  = super.getUser();
        if( user.getId() == this.getUser().getId()) return super.patchVisitor(visiteurBody);
        else throw new AccessDeniedException("Ce rapport ne vous appartient pas") ;
    }
}