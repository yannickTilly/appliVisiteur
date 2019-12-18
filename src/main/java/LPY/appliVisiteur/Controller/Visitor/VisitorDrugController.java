package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.Administrator.AdministratorDrugController;
import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Drug;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.View.Visiteur.DrugView;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("visitor")
public class VisitorDrugController  extends BaseController {
    @Autowired
    private AdministratorDrugController administratorDrugController;

    @RequestMapping(value = "drugs", method = RequestMethod.GET)
    @JsonView(DrugView.Medicament.class)
    public Collection<Drug> getDrugs() throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        return administratorDrugController.getDrugs();
    }

}
