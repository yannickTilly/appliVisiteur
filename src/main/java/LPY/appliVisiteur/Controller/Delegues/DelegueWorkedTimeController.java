package LPY.appliVisiteur.Controller.Delegues;

import LPY.appliVisiteur.Controller.Visitor.VisitorWorkedTimeController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("delegues")
public class DelegueWorkedTimeController extends VisitorWorkedTimeController {
}