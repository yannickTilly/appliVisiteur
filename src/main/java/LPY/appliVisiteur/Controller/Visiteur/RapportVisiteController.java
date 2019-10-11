package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.RapportVisite;
import LPY.appliVisiteur.Model.Repository.RapportVisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RapportVisiteController extends BaseController {
    @Autowired
    private RapportVisiteRepository rapportVisiteRepository;

    @RequestMapping(value = "rapportVisite/{id}", method = RequestMethod.GET)
    public Optional<RapportVisite> getRapportVisite(@PathVariable("id") Long id)
    {
        return rapportVisiteRepository.findById(id);
    }

    @RequestMapping(value = "rapportVisites", method = RequestMethod.GET)
    public Iterable<RapportVisite> getRapportVisites()
    {
        return rapportVisiteRepository.findAll();
    }
}
