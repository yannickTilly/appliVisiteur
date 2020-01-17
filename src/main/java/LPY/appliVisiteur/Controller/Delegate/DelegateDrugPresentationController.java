package LPY.appliVisiteur.Controller.Delegate;

import LPY.appliVisiteur.Controller.BaseController.DrugPresentationController;
import LPY.appliVisiteur.Model.Entity.DrugPresentation;
import LPY.appliVisiteur.Model.Entity.Report;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.DrugPresentationRepository;
import LPY.appliVisiteur.Model.Repository.DrugRepository;
import LPY.appliVisiteur.Model.Repository.PraticionnerRepository;
import LPY.appliVisiteur.Model.Repository.ReportRepository;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.PresentationMedicamentBody;
import LPY.appliVisiteur.Model.View.Visiteur.DrugPresentationView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("administrator")
@RolesAllowed("ROLE_ADMINISTRATOR")
public class DelegateDrugPresentationController extends DrugPresentationController {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private PraticionnerRepository praticionnerRepository;

    @Autowired
    private DrugPresentationRepository drugPresentationRepository;

    @RequestMapping(value = "drugPresentation", method = RequestMethod.POST)
    @JsonView(DrugPresentationView.PresentationMedicament.class)
    public Report postDrugPresentation(@RequestBody PresentationMedicamentBody presentationMedicamentBody)
            throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException
    {
        return super.postDrugPresentation(presentationMedicamentBody);
    }

    @RequestMapping(value = "drugPresentation/{idPresentationMedicament}", method = RequestMethod.DELETE)
    @JsonView(DrugPresentationView.PresentationMedicament.class)
    public Report deleteDrugPresentation(@PathVariable("idPresentationMedicament") Long idPresentationMedicament)
            throws RessouceNotFoundExeption
    {
        return super.deleteDrugPresentation(idPresentationMedicament);
    }

    @RequestMapping(value = "drugPresentation/{idPresentationMedicament}", method = RequestMethod.GET)
    @JsonView(DrugPresentationView.PresentationMedicament.class)
    public DrugPresentation getDrugPresentation(@PathVariable("idPresentationMedicament") Long idPresentationMedicament)
            throws RessouceNotFoundExeption
    {
        return  super.getDrugPresentation(idPresentationMedicament);
    }
}
