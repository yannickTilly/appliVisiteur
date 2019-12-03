package LPY.appliVisiteur.Controller.Administrator;

import LPY.appliVisiteur.Controller.BaseController;
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

@RestController
@RequestMapping("visitor")
public class AdministratorDrugController extends BaseController {
    @Autowired
    private DrugRepository drugRepository;

    @RequestMapping(value = "drug/{id}", method = RequestMethod.GET)
    @JsonView(DrugView.Medicament.class)
    public Drug getDepartment(@PathVariable("id") Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Drug drug = drugRepository.findOneById(id);
        if (drug == null)
        {
            throw new RessouceNotFoundExeption("drug not found");
        }
        return drug;
    }

    @RequestMapping(value = "drugs", method = RequestMethod.GET)
    @JsonView(DrugView.Medicament.class)
    public Iterable<Drug> getDrugs() throws JsonProcessingException {
        return drugRepository.findAll();
    }
}
