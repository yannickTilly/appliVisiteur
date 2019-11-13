package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.ReportRepository;
import LPY.appliVisiteur.Model.Repository.UserRepository;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.VisiteurBody;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("visiteur")
public class VisitorUserController extends BaseController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReportRepository reportRepository;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getVisiteur() throws UserNotFoundException, JsonProcessingException {
        return this.createResponse(this.getUser(), UserView.User.class);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PATCH)
    public String postVisiteur(@RequestBody VisiteurBody visiteurBody) throws UserNotFoundException, JsonProcessingException {

        User user = this.getUser();
        if (visiteurBody.getVille() != null)
        {
            user.setVille(visiteurBody.getVille());
        }
        if (visiteurBody.getCodePostal() != null)
        {
            user.setVille(visiteurBody.getCodePostal());
        }
        userRepository.save(user);
        return this.createResponse(this.getUser(), UserView.User.class);
    }
}