package LPY.appliVisiteur.Controller.Administrator;

import LPY.appliVisiteur.Controller.BaseController.BaseController;
import LPY.appliVisiteur.Model.Entity.Drug;
import LPY.appliVisiteur.Model.Entity.Report;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.DrugRepository;
import LPY.appliVisiteur.Model.Repository.PraticionnerRepository;
import LPY.appliVisiteur.Model.Repository.DrugPresentationRepository;
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
public class AdministratorDrugPresentationController extends BaseController {
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
    public Report postDrug(@RequestBody PresentationMedicamentBody presentationMedicamentBody)
            throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException
    {
        Report report = reportRepository.findOneByUserAndId(this.getUser(),presentationMedicamentBody.getIdRapportVisite());
        Drug drug = drugRepository.findOneById(presentationMedicamentBody.getIdMedicament());
        if (report == null || drug == null)
        {
            throw new RessouceNotFoundExeption("report or drug not found");
        }
        else
        {
            LPY.appliVisiteur.Model.Entity.DrugPresentation drugPresentation = new LPY.appliVisiteur.Model.Entity.DrugPresentation();
            drugPresentation.setReport(report);
            drugPresentation.setDrug(drug);
            report.getDrugPresentations().add(drugPresentation);
            drugPresentationRepository.save(drugPresentation);
            return report;
        }
    }

    @RequestMapping(value = "drugPresentation/{idPresentationMedicament}", method = RequestMethod.DELETE)
    @JsonView(DrugPresentationView.DrugPresentation.class)
    public Report deleteDrug(@PathVariable("idPresentationMedicament") Long idPresentationMedicament)
            throws RessouceNotFoundExeption
    {
        LPY.appliVisiteur.Model.Entity.DrugPresentation drugPresentation = drugPresentationRepository.findOneById(idPresentationMedicament);
        if (drugPresentation == null)
        {
            throw new RessouceNotFoundExeption("presentation medicament not found");
        }
        else
        {
            drugPresentationRepository.delete(drugPresentation);
            return drugPresentation.getReport();
        }

    }

    @RequestMapping(value = "drugPresentation/{idPresentationMedicament}", method = RequestMethod.GET)
    @JsonView(DrugPresentationView.DrugPresentation.class)
    public LPY.appliVisiteur.Model.Entity.DrugPresentation getDrug(@PathVariable("idPresentationMedicament") Long idPresentationMedicament)
            throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException
    {
        LPY.appliVisiteur.Model.Entity.DrugPresentation drugPresentation = drugPresentationRepository.findOneById(idPresentationMedicament);
        if (drugPresentation == null)
        {
            throw new RessouceNotFoundExeption("presentation medicament not found");
        }
        else
        {
            return drugPresentation;
        }

    }
}
