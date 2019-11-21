package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Drug;
import LPY.appliVisiteur.Model.Exception.RessourceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.DrugRepository;
import LPY.appliVisiteur.Model.View.Visiteur.DrugView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("visitor")
public class VisitorDrugController extends BaseController {
    @Autowired
    private DrugRepository drugRepository;

    @RequestMapping(value = "drug/{id}", method = RequestMethod.GET)
    public String getDepartment(@PathVariable("id") Long id) throws JsonProcessingException, RessourceNotFoundExeption {
        Drug drug = drugRepository.findOneById(id);
        if (drug == null)
        {
            throw new RessourceNotFoundExeption("drug not found");
        }
        return createResponse(drug, DrugView.Medicament.class);
    }

    @RequestMapping(value = "drugs", method = RequestMethod.GET)
    public String getDrugs() throws JsonProcessingException {
        return createResponse(drugRepository.findAll(), DrugView.Medicament.class);
    }
}
