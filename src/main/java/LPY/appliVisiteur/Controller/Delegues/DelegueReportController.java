package LPY.appliVisiteur.Controller.Delegues;

import LPY.appliVisiteur.Controller.Visitor.VisitorReportController;
import LPY.appliVisiteur.Model.Entity.Report;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.RessourceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.UserRepository;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;

@RestController
@RequestMapping("delegues")
public class DelegueReportController extends VisitorReportController {
    @Autowired
    private UserRepository userRepository;

    @Override
    @RequestMapping(value = "report/{id}", method = RequestMethod.GET)
    public String getReport(@PathVariable("id") Long id) throws UserNotFoundException, RessourceNotFoundExeption, JsonProcessingException {
        Report report = reportRepository.findOneByIdAndRegion(id, this.getUserEntity().getRegion());

        if (report == null) {
            throw new RessourceNotFoundExeption("No results found");
        } else {
            return this.createResponse(report, ReportView.RapportVisite.class);
        }
    }

    @Override
    @RequestMapping(value = "reports", method = RequestMethod.GET)
    public String getReports() throws UserNotFoundException, JsonProcessingException {
        Collection<Report> reports = this.getUserEntity().getRegion().getReports();
        return this.createResponse(reports, ReportView.DelegueRapportVisite.class);
    }

    @RequestMapping(value = "user/{userId}/reports", method = RequestMethod.GET)
    public String getReports(@PathVariable("userId") Long id) throws UserNotFoundException, JsonProcessingException {
        User user = userRepository.findOneById(id);
        Collection<Report> reports = reportRepository.findByUserAndRegion(user, this.getUserEntity().getRegion());

        if (user != null)
        {
            return this.createResponse(reports, ReportView.RapportVisite.class);
        }else {
            throw new UserNotFoundException("No user found with this id");
        }
    }
}