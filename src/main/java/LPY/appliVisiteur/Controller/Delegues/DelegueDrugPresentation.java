package LPY.appliVisiteur.Controller.Delegues;

import LPY.appliVisiteur.Controller.Visiteur.PresentationMedicamentController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("delegues")
public class DelegueDrugPresentation extends PresentationMedicamentController {
}