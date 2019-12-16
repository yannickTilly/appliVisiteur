package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Department;
import LPY.appliVisiteur.Model.Entity.Pratitionner;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.PraticionnerRepository;
import LPY.appliVisiteur.Model.View.Visiteur.DepartmentView;
import LPY.appliVisiteur.Model.View.Visiteur.PratitionnerView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("visitor")
public class VisitorPratitionnerController extends BaseController {
    @Autowired
    private PraticionnerRepository praticionnerRepository;

    @RequestMapping(value = "pratitionners", method = RequestMethod.GET)
    @JsonView(PratitionnerView.Praticien.class)
    public Collection<Pratitionner> getReports() throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        return (Collection<Pratitionner>) praticionnerRepository.findAll();
    }
}
