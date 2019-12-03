package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.Administrator.AdministratorReportController;
import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.*;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.RapportVisiteBody;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class visiteur extends BaseController {
    private AdministratorReportController administratorReportController;
    @RequestMapping(value = "report", method = RequestMethod.POST)
    @JsonView(ReportView.RapportVisite.class)
    public Report postReport(@RequestBody RapportVisiteBody rapportVisiteBody) throws UserNotFoundException, JsonProcessingException, RessouceNotFoundExeption {
        return administratorReportController.postReport(rapportVisiteBody, this.getUser().getId());
    }
}
