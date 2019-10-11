package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Repository.RapportVisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RapportVisiteController extends BaseController {
    @Autowired
    private RapportVisiteRepository rapportVisiteRepository;
}
