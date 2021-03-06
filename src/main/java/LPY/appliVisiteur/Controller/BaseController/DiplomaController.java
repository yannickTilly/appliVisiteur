package LPY.appliVisiteur.Controller.BaseController;

import LPY.appliVisiteur.Model.Entity.Diploma;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.DiplomaRepository;
import LPY.appliVisiteur.Model.View.Visiteur.DiplomaView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

public class DiplomaController extends BaseController {
    @Autowired
    private DiplomaRepository diplomaRepository;

    public Diploma getDiploma(Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Diploma diploma = diplomaRepository.findOneById(id);
        if (diploma == null)
        {
            throw new RessouceNotFoundExeption("diploma not found");
        }
        return diplomaRepository.findOneById(id);
    }

    public Iterable<Diploma> getDiplomas() throws JsonProcessingException {
        return diplomaRepository.findAll();
    }
}
