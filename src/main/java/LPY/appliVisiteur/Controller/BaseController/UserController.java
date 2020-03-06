package LPY.appliVisiteur.Controller.BaseController;

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

public class UserController extends BaseController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReportRepository reportRepository;

    public User getVisitor() throws UserNotFoundException{
        return this.getUser();
    }

    public User patchVisitor(VisiteurBody visiteurBody) throws UserNotFoundException, AccessDeniedException {

        User user = this.getUser();

        if (visiteurBody.getVille() != null)
        {
            user.setVille(visiteurBody.getVille());
        }
        if (visiteurBody.getCodePostal() != null)
        {
            user.setCodePostal(visiteurBody.getCodePostal());
        }
        if (visiteurBody.getCodePostal() != null)
        {
            user.setCodePostal(visiteurBody.getCodePostal());
        }
        if(visiteurBody.getNumeroVoie() != null)
        {
            user.setNumberStreet(visiteurBody.getNumeroVoie());
        }
        if(visiteurBody.getTypeVoie() != null)
        {
            user.setStreetType(visiteurBody.getTypeVoie());
        }
        if(visiteurBody.getNomVoie() != null)
        {
            user.setStreetName(visiteurBody.getNomVoie());
        }
        userRepository.save(user);
        return this.getUser();
    }
}