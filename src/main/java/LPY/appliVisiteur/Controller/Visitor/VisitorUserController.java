package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.ReportRepository;
import LPY.appliVisiteur.Model.Repository.UserRepository;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.UserBody;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("visitor")
public class VisitorUserController extends BaseController
{
    @Autowired
    protected UserRepository userRepository;

    @Autowired
    private ReportRepository reportRepository;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser() throws UserNotFoundException, JsonProcessingException {
        return this.createResponse(this.getUserEntity(), UserView.User.class);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PATCH)
    public String patchUser(@RequestBody UserBody userBody) throws UserNotFoundException, JsonProcessingException {

        User user = this.getUserEntity();
        if (userBody.getVille() != null)
        {
            user.setVille(userBody.getVille());
        }
        if (userBody.getCodePostal() != null)
        {
            user.setVille(userBody.getCodePostal());
        }
        userRepository.save(user);
        return this.createResponse(this.getUserEntity(), UserView.User.class);
    }
}