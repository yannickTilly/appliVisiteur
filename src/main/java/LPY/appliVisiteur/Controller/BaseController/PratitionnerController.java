package LPY.appliVisiteur.Controller.BaseController;

import LPY.appliVisiteur.Model.Entity.Pratitionner;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.PraticionnerRepository;
import LPY.appliVisiteur.Model.View.Visiteur.PratitionnerView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Collection;

public class PratitionnerController extends BaseController {
    @Autowired
    private PraticionnerRepository praticionnerRepository;

    public Pratitionner getDepartment(@PathVariable("id") Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Pratitionner pratitionner = praticionnerRepository.findOneById(id);
        if (pratitionner == null)
        {
            throw new RessouceNotFoundExeption("pratitionner not found");
        }
        return pratitionner;
    }

    public Collection<Pratitionner> getPratitionners() throws JsonProcessingException {
        return (Collection<Pratitionner>) praticionnerRepository.findAll();
    }
}
