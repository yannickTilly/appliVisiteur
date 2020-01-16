package LPY.appliVisiteur.Config;

import LPY.appliVisiteur.Service.Authentificator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    Authentificator customerService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        //
    }

    @Override
    protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws UsernameNotFoundException {

        Object token = usernamePasswordAuthenticationToken.getCredentials();
        if (token == null)
        {
            throw new UsernameNotFoundException("no token");
        }
        Optional<User> springUser = customerService.findByToken(String.valueOf(token));
        if (springUser.isPresent())
        {
            return  springUser.get();
        }
        else
        {
            throw new UsernameNotFoundException("eee");
        }
    }
}
