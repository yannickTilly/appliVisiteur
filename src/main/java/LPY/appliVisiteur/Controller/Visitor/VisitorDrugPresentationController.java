package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Drug;
import LPY.appliVisiteur.Model.Entity.DrugPresentation;
import LPY.appliVisiteur.Model.Entity.Report;
import LPY.appliVisiteur.Model.Exception.RessourceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.DrugRepository;
import LPY.appliVisiteur.Model.Repository.PraticionnerRepository;
import LPY.appliVisiteur.Model.Repository.DrugPresentationRepository;
import LPY.appliVisiteur.Model.Repository.ReportRepository;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.PresentationMedicamentBody;
import LPY.appliVisiteur.Model.View.Visiteur.DrugPresentationView;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("visitor")
public class VisitorDrugPresentationController extends BaseController {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private PraticionnerRepository praticionnerRepository;

    @Autowired
    private DrugPresentationRepository drugPresentationRepository;

    @RequestMapping(value = "drugPresentation", method = RequestMethod.POST)
    public String patchDrug(@RequestBody PresentationMedicamentBody presentationMedicamentBody)
            throws UserNotFoundException, RessourceNotFoundExeption, JsonProcessingException
    {
        Report report = reportRepository.findOneByUserAndId(this.getUserEntity(),presentationMedicamentBody.getIdRapportVisite());
        Drug drug = drugRepository.findOneById(presentationMedicamentBody.getIdMedicament());
        if (report == null || drug == null)
        {
            throw new RessourceNotFoundExeption("report or drug not found");
        }
        else
        {
            DrugPresentation drugPresentation = new DrugPresentation();
            drugPresentation.setReport(report);
            drugPresentation.setDrug(drug);
            report.getDrugPresentations().add(drugPresentation);
            drugPresentationRepository.save(drugPresentation);
            return this.createResponse(report, ReportView.RapportVisite.class);
        }
    }

    @RequestMapping(value = "drugPresentation/{idPresentationMedicament}", method = RequestMethod.DELETE)
    public String deleteDrug(@PathVariable("idPresentationMedicament") Long idPresentationMedicament)
            throws UserNotFoundException, RessourceNotFoundExeption, JsonProcessingException
    {
        DrugPresentation drugPresentation = drugPresentationRepository.findOneById(idPresentationMedicament);
        if (drugPresentation == null)
        {
            throw new RessourceNotFoundExeption("presentation medicament not found");
        }
        else
        {
            drugPresentationRepository.delete(drugPresentation);
            return this.createResponse(drugPresentation.getReport(), ReportView.RapportVisite.class);
        }

    }






    @RequestMapping(value = "drugPresentation/{idPresentationMedicament}", method = RequestMethod.GET)
    public String getDrug(@PathVariable("idPresentationMedicament") Long idPresentationMedicament)
            throws UserNotFoundException, RessourceNotFoundExeption, JsonProcessingException
    {
        DrugPresentation drugPresentation = drugPresentationRepository.findOneById(idPresentationMedicament);
        if (drugPresentation == null)
        {
            throw new RessourceNotFoundExeption("presentation medicament not found");
        }
        else
        {
            return this.createResponse(drugPresentation, DrugPresentationView.PresentationMedicament.class);
        }

    }
}