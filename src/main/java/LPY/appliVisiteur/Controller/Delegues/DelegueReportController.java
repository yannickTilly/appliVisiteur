package LPY.appliVisiteur.Controller.Delegues;

import LPY.appliVisiteur.Controller.Administrator.AdministratorReportController;
import LPY.appliVisiteur.Model.Entity.Report;
import LPY.appliVisiteur.Model.Entity.User;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.UserRepository;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;

@RestController
@RequestMapping("delegues")
public class DelegueReportController extends AdministratorReportController {
    @Autowired
    private UserRepository userRepository;

    @Override
    @RequestMapping(value = "report/{id}", method = RequestMethod.GET)
    @JsonView(ReportView.DelegueRapportVisite.class)
    public Report getReport(@PathVariable("id") Long id) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        Report report = reportRepository.findOneByIdAndRegion(id, this.getUser().getRegion());

        if (report == null) {
            throw new RessouceNotFoundExeption("No results found");
        } else {
            return report;
        }
    }

    @Override
    @RequestMapping(value = "reports", method = RequestMethod.GET)
    @JsonView(ReportView.DelegueRapportVisite.class)
    public Collection<Report> getReports() throws UserNotFoundException, JsonProcessingException {
        Collection<Report> reports = this.getUser().getRegion().getReports();
        return reports;
    }

    @RequestMapping(value = "user/{userId}/reports", method = RequestMethod.GET)
    @JsonView(ReportView.DelegueRapportVisite.class)
    public Collection<Report> getReports(@PathVariable("userId") Long id) throws UserNotFoundException, JsonProcessingException {
        User user = userRepository.findOneById(id);
        Collection<Report> reports = reportRepository.findByUserAndRegion(user, this.getUser().getRegion());
        if (user != null)
        {
            return reports;
        }else {
            throw new UserNotFoundException("No user found with this id");
        }
    }
}
