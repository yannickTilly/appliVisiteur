package LPY.appliVisiteur.Controller.BaseController;

import LPY.appliVisiteur.Model.Entity.Drug;
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

public class DrugPresentationController extends BaseController {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private PraticionnerRepository praticionnerRepository;

    @Autowired
    private DrugPresentationRepository drugPresentationRepository;

    public Report postDrugPresentation(PresentationMedicamentBody presentationMedicamentBody)
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
            DrugPresentation drugPresentation = new DrugPresentation();
            drugPresentation.setReport(report);
            drugPresentation.setDrug(drug);
            report.getDrugPresentations().add(drugPresentation);
            drugPresentationRepository.save(drugPresentation);
            return report;
        }
    }

    public Report deleteDrugPresentation(Long idPresentationMedicament)
            throws RessouceNotFoundExeption
    {
        DrugPresentation drugPresentation = drugPresentationRepository.findOneById(idPresentationMedicament);
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

    public DrugPresentation getDrugPresentation(Long idPresentationMedicament)
            throws RessouceNotFoundExeption
    {
        DrugPresentation drugPresentation = drugPresentationRepository.findOneById(idPresentationMedicament);
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
