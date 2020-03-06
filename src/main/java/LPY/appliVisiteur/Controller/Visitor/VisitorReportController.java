package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.Administrator.AdministratorReportController;
import LPY.appliVisiteur.Controller.BaseController.BaseController;
import LPY.appliVisiteur.Controller.BaseController.ReportController;
import LPY.appliVisiteur.Model.Entity.*;
import LPY.appliVisiteur.Model.Exception.AccessDeniedException;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.DrugRepository;
import LPY.appliVisiteur.Model.Repository.UserRepository;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.ReportBody;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("visitor")
@Secured("ROLE_VISITOR")
public class VisitorReportController extends ReportController {
    @Autowired
    private AdministratorReportController administratorReportController;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DrugRepository drugRepository;

    @RequestMapping(value = "report", method = RequestMethod.POST)
    @JsonView(ReportView.RapportVisite.class)
    public Report postReport(@RequestBody ReportBody reportBody) throws UserNotFoundException, JsonProcessingException, RessouceNotFoundExeption {
        return super.postReport(reportBody, this.getUser().getId());
    }

    @RequestMapping(value = "report/{reportId}", method = RequestMethod.GET)
    @JsonView(ReportView.RapportVisite.class)
    public Report getReport(@PathVariable long reportId) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException, AccessDeniedException {
        Report report = super.getReport(reportId);
        if( report.getUser().getId() == this.getUser().getId()) return super.getReport(reportId);
        else throw new AccessDeniedException("Ce rapport ne vous appartient pas");
    }

    @RequestMapping(value = "reports", method = RequestMethod.GET)
    @JsonView(ReportView.RapportVisite.class)
    public Collection<Report> getReports() throws UserNotFoundException, JsonProcessingException {
        return super.getReportsByUser(this.getUser());
    }

    @RequestMapping(value = "report/{reportId}", method = RequestMethod.PATCH)
    @JsonView(ReportView.RapportVisite.class)
    public Report patchReport(@PathVariable long reportId, @RequestBody ReportBody reportBody) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException, AccessDeniedException {
        Report report = super.getReport(reportId);
        if ( report.getUser().getId() == this.getUser().getId()) return super.patchReport(reportId, reportBody);
        else throw new AccessDeniedException("Ce rapport ne vous appartient pas") ;
    }

    @RequestMapping(value = "report/{reportId}", method = RequestMethod.DELETE)
    @JsonView(ReportView.RapportVisite.class)
    public Collection<Report> deleteReport(@PathVariable long reportId) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException, AccessDeniedException {
        Report report = super.getReport(reportId);
        if ( report.getUser().getId() == this.getUser().getId()) return super.deleteReport(reportId);
        else throw new AccessDeniedException("Ce rapport ne vous appartient pas") ;
    }
}
