package LPY.appliVisiteur.Controller.Administrator;

import LPY.appliVisiteur.Controller.BaseController.BaseController;
import LPY.appliVisiteur.Model.Entity.*;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.*;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.ReportBody;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("administrator")
@RolesAllowed("ROLE_ADMINISTRATOR")
public class AdministratorReportController extends BaseController {
    @Autowired
    protected ReportRepository reportRepository;

    @Autowired
    protected DrugRepository drugRepository;

    @Autowired
    protected PraticionnerRepository praticionnerRepository;

    @Autowired
    protected DrugPresentationRepository drugPresentationRepository;

    @Autowired
    protected UserRepository userRepository;

    @RequestMapping(value = "report/{id}", method = RequestMethod.GET)
    @JsonView(ReportView.Report.class)
    public Report getReport(@PathVariable("id") Long id) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        Report report = reportRepository.findOneById(id);
        if (report == null)
        {
            throw new RessouceNotFoundExeption("report not found");
        }
        else
        {
            return report;
        }
    }

    @RequestMapping(value = "report/{id}", method = RequestMethod.DELETE)
    @JsonView(ReportView.Report.class)
    public Collection<Report> deleteReport(@PathVariable("id") Long id) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        Report report = reportRepository.findOneById(id);
        if (report == null)
        {
            throw new RessouceNotFoundExeption("report not found");
        }
        else
        {
            reportRepository.delete(report);
            return this.getUser().getReports();
        }

    }


    @RequestMapping(value = "reports", method = RequestMethod.GET)
    @JsonView(ReportView.Report.class)
    public Collection<Report> getReports() throws UserNotFoundException, JsonProcessingException {
        Collection<Report> reports = (Collection<Report>) reportRepository.findAll();
        return reports;
    }

    @RequestMapping(value = "user/{idUser}/report", method = RequestMethod.POST)
    @JsonView(ReportView.Report.class)
    public Report postReport(@RequestBody ReportBody reportBody, @PathVariable("idUser") long idUser) throws UserNotFoundException, JsonProcessingException, RessouceNotFoundExeption {
        User user = userRepository.findOneById(idUser);
        Report report = new Report();
        Collection<DrugPresentation> drugPresentations = new ArrayList<DrugPresentation>();
        for (Long medicamentId : reportBody.getMedicamentIds()) {
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
                throw new RessouceNotFoundExeption("drug not found");
            }
        }
        Pratitionner pratitionner = praticionnerRepository.findOneById(reportBody.getPraticienId());
        if (pratitionner != null)
        {
            report.setPratitionner(pratitionner);
        }
        else
        {
            throw new RessouceNotFoundExeption("pratitionner not found");
        }

        report.setUser(user);
        report.setRegion(user.getRegion());
        report.setDrugPresentations(drugPresentations);
        report.setDescription(reportBody.getNote());
        report.setDate(reportBody.getLocalDate());
        reportRepository.save(report);
        drugPresentationRepository.saveAll(drugPresentations);
        return report;
    }

    @RequestMapping(value = "report/{id}", method = RequestMethod.PATCH)
    @JsonView(ReportView.Report.class)
    public Report patchReport(@PathVariable("id") Long id, @RequestBody ReportBody reportBody) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        Report report = reportRepository.findOneByUserAndId(this.getUser(),id);
        if (report == null)
        {
            throw new RessouceNotFoundExeption("report not found");
        }
        else
        {
            if (reportBody.getNote() != null)
            {
                report.setDescription(reportBody.getNote());
            }
            reportRepository.save(report);
            return report;
        }

    }
}
