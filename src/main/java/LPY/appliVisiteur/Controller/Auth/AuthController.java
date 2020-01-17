package LPY.appliVisiteur.Controller.Auth;

import LPY.appliVisiteur.Controller.BaseController.BaseController;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.UserRepository;
import LPY.appliVisiteur.Model.RequestBody.Credential;
import LPY.appliVisiteur.Model.ResponseBody.AuthResponse;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthController extends BaseController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public AuthResponse getToken(@RequestBody Credential credential) throws UserNotFoundException {
        User user = userRepository.findByLogin(credential.getLogin());
        if(user != null)
        {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("id", user.getId())
                    .withClaim("role", user.getRole())
                    .sign(algorithm);
            AuthResponse authResponse = new AuthResponse();
            authResponse.setToken(token);
            return authResponse;
        }
        throw new UserNotFoundException("login non trouvé");
    }
}