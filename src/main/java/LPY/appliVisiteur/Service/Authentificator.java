package LPY.appliVisiteur.Service;

import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Repository.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class Authentificator {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser()
    {
        String token = request.getHeader("authorization");
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);
        Optional<User> user = userRepository.findById(jwt.getClaim("id").asInt());
        return user;
    }
}
