package LPY.appliVisiteur.Controller.Delegues;

import LPY.appliVisiteur.Controller.Administrator.AdministratorDrugController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("delegues")
public class DelegueDrugController extends AdministratorDrugController {
}
