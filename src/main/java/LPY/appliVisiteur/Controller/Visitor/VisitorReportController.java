package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.*;
import LPY.appliVisiteur.Model.Exception.RessourceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.DrugRepository;
import LPY.appliVisiteur.Model.Repository.PraticionnerRepository;
import LPY.appliVisiteur.Model.Repository.DrugPresentationRepository;
import LPY.appliVisiteur.Model.Repository.ReportRepository;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.RapportVisiteBody;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("visitor")
public class VisitorReportController extends BaseController {
    @Autowired
    protected ReportRepository reportRepository;

    @Autowired
    protected DrugRepository drugRepository;

    @Autowired
    protected PraticionnerRepository praticionnerRepository;

    @Autowired
    protected DrugPresentationRepository drugPresentationRepository;

    @RequestMapping(value = "report/{id}", method = RequestMethod.GET)
    public String getReport(@PathVariable("id") Long id) throws UserNotFoundException, RessourceNotFoundExeption, JsonProcessingException {
        Report report = reportRepository.findOneByUserAndId(this.getUserEntity(),id);
        if (report == null)
        {
            throw new RessourceNotFoundExeption("report not found");
        }
        else
        {
            return this.createResponse(report, ReportView.RapportVisite.class);
        }

    }

    @RequestMapping(value = "report/{id}", method = RequestMethod.DELETE)
    public String deleteReport(@PathVariable("id") Long id) throws UserNotFoundException, RessourceNotFoundExeption, JsonProcessingException {
        Report report = reportRepository.findOneByUserAndId(this.getUserEntity(),id);
        if (report == null)
        {
            throw new RessourceNotFoundExeption("report not found");
        }
        else
        {
            reportRepository.delete(report);
            return this.createResponse(this.getUserEntity().getReports(), ReportView.RapportVisite.class);
        }

    }

    @RequestMapping(value = "reports", method = RequestMethod.GET)
    public String getReports() throws UserNotFoundException, JsonProcessingException {
        User user = this.getUserEntity();
        Collection<Report> reports = reportRepository.findByUser(user);
        return this.createResponse(reports, ReportView.RapportVisite.class);
    }

    @RequestMapping(value = "report", method = RequestMethod.POST)
    public String postReport(@RequestBody RapportVisiteBody rapportVisiteBody) throws UserNotFoundException, JsonProcessingException, RessourceNotFoundExeption {
        User user = this.getUserEntity();
        Report report = new Report();
        Collection<DrugPresentation> drugPresentations = new ArrayList<DrugPresentation>();
        for (Long medicamentId : rapportVisiteBody.getMedicamentId()) {
            Drug drug = drugRepository.findOneById(medicamentId);
            if (drug != null)
            {
                DrugPresentation drugPresentation = new DrugPresentation();
                drugPresentation.setDrug(drug)
                        .setReport(report);
                drugPresentations.add(drugPresentation);
            }
            else
            {
                throw new RessourceNotFoundExeption("drug not found");
            }
        }
        Pratitionner pratitionner = praticionnerRepository.findOneById(rapportVisiteBody.getPraticienId());
        if (pratitionner != null)
        {
            report.setPratitionner(pratitionner);
        }
        else
        {
            throw new RessourceNotFoundExeption("pratitionner not found");
        }

        report.setUser(user);
        report.setDrugPresentations(drugPresentations);
        report.setDescription(rapportVisiteBody.getNote());
        reportRepository.save(report);
        drugPresentationRepository.saveAll(drugPresentations);
        return this.createResponse(report, ReportView.RapportVisite.class);
    }

    @RequestMapping(value = "report/{id}", method = RequestMethod.PATCH)
    public String patchReport(@PathVariable("id") Long id, @RequestBody RapportVisiteBody rapportVisiteBody) throws UserNotFoundException, RessourceNotFoundExeption, JsonProcessingException {
        Report report = reportRepository.findOneByUserAndId(this.getUserEntity(),id);
        if (report == null)
        {
            throw new RessourceNotFoundExeption("report not found");
        }
        else
        {
            if (rapportVisiteBody.getNote() != null)
            {
                report.setDescription(rapportVisiteBody.getNote());
            }
            reportRepository.save(report);
            return this.createResponse(report, ReportView.RapportVisite.class);
        }

    }
}