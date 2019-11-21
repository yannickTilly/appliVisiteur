package LPY.appliVisiteur.Controller.Administrator;

import LPY.appliVisiteur.Controller.Visitor.VisitorDrugController;
import LPY.appliVisiteur.Model.Entity.Drug;
import LPY.appliVisiteur.Model.Exception.RessourceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.DrugRepository;
import LPY.appliVisiteur.Model.View.Visiteur.DrugView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("administrator")
public class AdministratorDrugController extends VisitorDrugController {
    @Autowired
    private DrugRepository drugRepository;

    @RequestMapping( value = "drug",  method = RequestMethod.POST)
    public String postDrug(@RequestBody Drug drug)
            throws UserNotFoundException, JsonProcessingException, RessourceNotFoundExeption
    {
        this.getUserEntity();
        drugRepository.save(drug);
        return this.createResponse(drug, DrugView.Medicament.class);
    }

    @RequestMapping ( value = "drug/{idDrug}",  method = RequestMethod.DELETE)
    public String deleteDrug(@PathVariable("idDrug")long idDrug)
            throws UserNotFoundException, JsonProcessingException, RessourceNotFoundExeption

    {
        Drug drug  = drugRepository.findOneById(idDrug);
        if (drug == null)
        {
            throw new RessourceNotFoundExeption("Drug not found");
        }
        else
        {
            drugRepository.delete(drug);
            return this.createResponse(drug.getId(), DrugView.Medicament.class);
        }
    }



}
