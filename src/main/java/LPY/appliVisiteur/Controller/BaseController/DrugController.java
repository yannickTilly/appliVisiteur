package LPY.appliVisiteur.Controller.BaseController;

import LPY.appliVisiteur.Model.Entity.Drug;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.DrugRepository;
import LPY.appliVisiteur.Model.View.Visiteur.DrugView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Collection;

public class DrugController extends BaseController {
    @Autowired
    private DrugRepository drugRepository;

    public Drug getDrug(Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Drug drug = drugRepository.findOneById(id);
        if (drug == null)
        {
            throw new RessouceNotFoundExeption("drug not found");
        }
        return drug;
    }

    public Collection<Drug> getDrugs() throws JsonProcessingException {
        return (Collection<Drug>) drugRepository.findAll();
    }
}
