package LPY.appliVisiteur.Controller;

import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Service.Authentificator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class BaseController {
    @Autowired
    private Authentificator authentificator;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private EntityManagerFactory em;

    protected User getUser() throws UserNotFoundException {
        return this.authentificator.getUser();
    }

    protected String createResponse(Object response, Class group) throws JsonProcessingException {
        return mapper.writerWithView(group)
                .writeValueAsString(response);
    }

    protected EntityManager getEm()
    {
        return this.em.createEntityManager();
    }
}
