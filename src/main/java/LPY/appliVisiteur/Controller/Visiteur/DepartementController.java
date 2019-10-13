package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Departement;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.DepartementRepository;
import LPY.appliVisiteur.Model.View.Visiteur.DepartementView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DepartementController extends BaseController {
    @Autowired
    private DepartementRepository departementRepository;

    @RequestMapping(value = "departement/{id}", method = RequestMethod.GET)
    public String getDepartement(@PathVariable("id") long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Departement departement = departementRepository.findOneById(id);
        if (departement == null)
        {
            throw new RessouceNotFoundExeption("departement not found");
        }
        return this.createResponse(departement, DepartementView.Departement.class);
    }

    @RequestMapping(value = "departements", method = RequestMethod.GET)
    public String getDepartements() throws JsonProcessingException {
        return this.createResponse(departementRepository.findAll(),DepartementView.Departement.class);
    }
}
