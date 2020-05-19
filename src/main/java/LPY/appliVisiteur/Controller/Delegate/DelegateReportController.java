package LPY.appliVisiteur.Controller.Delegate;

import LPY.appliVisiteur.Controller.Administrator.AdministratorReportController;
import LPY.appliVisiteur.Controller.Visitor.VisitorReportController;
import LPY.appliVisiteur.Model.Entity.Report;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.UserRepository;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.security.RolesAllowed;
import java.util.Collection;

@RestController
@RequestMapping("delegate")
@Secured("ROLE_DELEGATE")
public class DelegateReportController extends VisitorReportController {
    @Autowired
    private UserRepository userRepository;

    @Override
    @RequestMapping(value = "report/{reportId}", method = RequestMethod.GET)
    @JsonView(ReportView.DelegueRapportVisite.class)
    public Report getReport(@PathVariable("reportId") long reportId) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        Report report = reportRepository.findOneByIdAndRegion(reportId, this.getUser().getRegion());

        if (report == null) {
            throw new RessouceNotFoundExeption("No results found");
        } else {
            return report;
        }
    }

    @Override
    @RequestMapping(value = "reports", method = RequestMethod.GET)
    @JsonView(ReportView.DelegueRapportVisite.class)
    public Collection<Report> getReports() throws UserNotFoundException {
        Collection<Report> reports = this.getUser().getRegion().getReports();
        return reports;
    }

    @RequestMapping(value = "user/{userId}/reports", method = RequestMethod.GET)
    @JsonView(ReportView.DelegueRapportVisite.class)
    public Collection<Report> getReports(@PathVariable("userId") Long id) throws UserNotFoundException {
        User user = userRepository.findOneById(id);
        Collection<Report> reports = reportRepository.findByUserAndRegion(user, this.getUser().getRegion());
        if (user != null) {
            return reports;
        } else {
            throw new UserNotFoundException("No user found with this id");
        }
    }
}
