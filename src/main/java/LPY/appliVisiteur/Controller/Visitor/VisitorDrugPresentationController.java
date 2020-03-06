package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.BaseController.DrugPresentationController;
import LPY.appliVisiteur.Model.Entity.Report;
import LPY.appliVisiteur.Model.Exception.AccessDeniedException;
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
@RequestMapping("visitor")
@RolesAllowed("ROLE_VISITOR")
public class VisitorDrugPresentationController extends DrugPresentationController {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private PraticionnerRepository praticionnerRepository;

    @Autowired
    private DrugPresentationRepository drugPresentationRepository;

    @RequestMapping(value = "drugPresentation", method = RequestMethod.POST)
    @JsonView(DrugPresentationView.DrugPresentation.class)
    public Report postDrugPresentation(@RequestBody PresentationMedicamentBody presentationMedicamentBody)
            throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException
    {
        return super.postDrugPresentation(presentationMedicamentBody);
    }

    @RequestMapping(value = "drugPresentation/{idPresentationMedicament}", method = RequestMethod.DELETE)
    @JsonView(DrugPresentationView.DrugPresentation.class)
    public Report deleteDrugPresentation(@PathVariable("idPresentationMedicament") Long drugPresentationId) throws RessouceNotFoundExeption, AccessDeniedException, UserNotFoundException {
        LPY.appliVisiteur.Model.Entity.DrugPresentation drugPresentation = super.getDrugPresentation(drugPresentationId);
        if( drugPresentation.getReport().getUser().getId() == this.getUser().getId()) return super.deleteDrugPresentation(drugPresentationId);
        else throw new AccessDeniedException("Ce rapport ne vous appartient pas");

    }

    @RequestMapping(value = "drugPresentation/{drugPresentationId}", method = RequestMethod.GET)
    @JsonView(DrugPresentationView.DrugPresentation.class)
    public LPY.appliVisiteur.Model.Entity.DrugPresentation getDrugPresentation(@PathVariable("drugPresentationId") Long drugPresentationId)
            throws RessouceNotFoundExeption, AccessDeniedException, UserNotFoundException {
        LPY.appliVisiteur.Model.Entity.DrugPresentation drugPresentation = super.getDrugPresentation(drugPresentationId);
        if( drugPresentation.getReport().getUser().getId() == this.getUser().getId()) return super.getDrugPresentation(drugPresentationId);
        else throw new AccessDeniedException("Ce rapport ne vous appartient pas");
    }
}
