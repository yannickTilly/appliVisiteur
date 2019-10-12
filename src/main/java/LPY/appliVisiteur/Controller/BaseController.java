package LPY.appliVisiteur.Controller;

import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.View.Visiteur.RapportVisiteView;
import LPY.appliVisiteur.Service.Authentificator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BaseController {
    @Autowired
    private Authentificator authentificator;
    @Autowired
    private ObjectMapper mapper;

    protected User getUser() throws UserNotFoundException {
        return this.authentificator.getUser();
    }

    protected String createResponse(Object response, Class group) throws JsonProcessingException {
        return mapper.writerWithView(group)
                .writeValueAsString(response);
    }
}
