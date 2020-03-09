package LPY.appliVisiteur.Controller.BaseController;

import LPY.appliVisiteur.Model.Entity.*;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.*;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.ReportBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

public class ReportController extends BaseController {
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

    public Report getReport(Long id) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
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
    public Collection<Report> getReportsByUser( User user)  {
        return reportRepository.findByUser(user);
    }

    public Collection<Report> deleteReport(Long id) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
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

    public Collection<Report> getReports() throws UserNotFoundException, JsonProcessingException {
        Collection<Report> reports = (Collection<Report>) reportRepository.findAll();
        return reports;
    }

    public Report postReport(ReportBody reportBody, long idUser) throws UserNotFoundException, JsonProcessingException, RessouceNotFoundExeption {
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
        report.setLabel(reportBody.getLabel());
        report.setUser(user);
        report.setRegion(user.getRegion());
        report.setDrugPresentations(drugPresentations);
        report.setDescription(reportBody.getNote());
        report.setDate(reportBody.getLocalDate());
        reportRepository.save(report);
        drugPresentationRepository.saveAll(drugPresentations);
        return report;
    }

    public Report patchReport(Long id, ReportBody reportBody) throws UserNotFoundException, RessouceNotFoundExeption {
        Report report = reportRepository.findOneByUserAndId(this.getUser(),id);
        if (report == null)
        {
            throw new RessouceNotFoundExeption("report not found");
        }
        else
        {
            if (report.getLabel()!= null)
            {
                report.setLabel(reportBody.getLabel());
            }
            if (reportBody.getNote() != null)
            {
                report.setDescription(reportBody.getNote());
            }
            reportRepository.save(report);
            return report;
        }
    }
}
