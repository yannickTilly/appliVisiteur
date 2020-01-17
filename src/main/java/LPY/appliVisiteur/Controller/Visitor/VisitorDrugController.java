package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.BaseController.BaseController;
import LPY.appliVisiteur.Controller.BaseController.DrugController;
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

import java.util.Collection;

@RestController
@RequestMapping("visitor")
public class VisitorDrugController  extends DrugController {

    @Autowired
    private DrugRepository drugRepository;

    @RequestMapping(value = "drug/{id}", method = RequestMethod.GET)
    @JsonView(DrugView.Medicament.class)
    public Drug getDrug(@PathVariable("id") Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        return super.getDrug(id);
    }

    @RequestMapping(value = "drugs", method = RequestMethod.GET)
    @JsonView(DrugView.Medicament.class)
    public Collection<Drug> getDrugs() throws JsonProcessingException {
        return super.getDrugs();
    }
}
