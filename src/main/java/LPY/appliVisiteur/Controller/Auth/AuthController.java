package LPY.appliVisiteur.Controller.Auth;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Repository.UserRepository;
import LPY.appliVisiteur.Model.RequestBody.Credential;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthController extends BaseController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public String getVisiteur(@RequestBody Credential credential) {
        User user = userRepository.findByLogin(credential.getLogin());
        if(user != null)
        {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("id", user.getId())
                    .sign(algorithm);
            return token;
        }

        return "mauvais login";
    }
}