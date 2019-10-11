package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Repository.PeriodeTravailleeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeriodeTravailleeController extends BaseController {
    @Autowired
    private PeriodeTravailleeRepository periodeTravailleeRepository;
}
