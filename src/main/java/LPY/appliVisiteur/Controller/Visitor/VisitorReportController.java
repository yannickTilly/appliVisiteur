package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.Administrator.AdministratorReportController;
import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.*;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.ReportBody;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("visitor")
public class VisitorReportController extends BaseController {
    @Autowired
    private AdministratorReportController administratorReportController;

    @RequestMapping(value = "report", method = RequestMethod.POST)
    @JsonView(ReportView.RapportVisite.class)
    public Report postReport(@RequestBody ReportBody reportBody) throws UserNotFoundException, JsonProcessingException, RessouceNotFoundExeption {

        return administratorReportController.postReport(reportBody, this.getUser().getId());
    }

    @RequestMapping(value = "report/{reportId}", method = RequestMethod.GET)
    @JsonView(ReportView.RapportVisite.class)
    public Report getReport(@PathVariable long reportId) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        return administratorReportController.getReport(reportId);
    }

    @RequestMapping(value = "reports", method = RequestMethod.GET)
    @JsonView(ReportView.RapportVisite.class)
    public Collection<Report> getReports() throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        return this.getUser().getReports();
    }

    @RequestMapping(value = "report/{reportId}", method = RequestMethod.PATCH)
    @JsonView(ReportView.RapportVisite.class)
    public Report patchReport(@PathVariable long reportId, @RequestBody ReportBody reportBody) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        return administratorReportController.patchReport(reportId, reportBody);
    }

    @RequestMapping(value = "report/{reportId}", method = RequestMethod.DELETE)
    @JsonView(ReportView.RapportVisite.class)
    public Collection<Report> deleteReport(@PathVariable long reportId) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        return administratorReportController.deleteReport(reportId);
    }
}
