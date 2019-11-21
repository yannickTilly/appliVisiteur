package LPY.appliVisiteur.Controller.Administrator;

import LPY.appliVisiteur.Controller.Visitor.VisitorUserController;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.RessourceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.UserRepository;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.UserBody;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("administrator")

public class AdministratorVisitorController extends VisitorUserController {
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id") Long id) throws UserNotFoundException, RessourceNotFoundExeption, JsonProcessingException {
        User user = this.userRepository.findOneById(id);
        if (user == null) {
            throw new RessourceNotFoundExeption("User not found");
        }
        else
        {
            return this.createResponse(user, UserView.User.class);
        }

    }

















    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String postUser(@RequestBody UserBody userBody) throws UserNotFoundException, RessourceNotFoundExeption, JsonProcessingException {
        User user  = new User();
        user.setPrenom(userBody.getPrenom());
        user.setNom(userBody.getNom());
        user.setMatricule(userBody.getMatricule());
        user.setLogin(userBody.getLogin());
        user.setPassword(user.getPassword());
        user.setVille(userBody.getVille());
        user.setCodePostal(userBody.getCodePostal());
        user.setHiringDate(userBody.getHiringDate());
        


        return this.createResponse(user, UserView.User.class);
    }















}
