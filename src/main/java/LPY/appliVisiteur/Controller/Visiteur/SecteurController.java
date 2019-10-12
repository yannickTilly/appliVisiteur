package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Secteur;
import LPY.appliVisiteur.Model.Repository.SecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SecteurController extends BaseController {
    @Autowired
    private SecteurRepository secteurRepository;

    @RequestMapping(value = "secteur/{id}", method = RequestMethod.GET)
    public Optional<Secteur> getSecteur(@PathVariable("id") Long id)
    {
        return secteurRepository.findById(id);
    }

    @RequestMapping(value = "secteurs", method = RequestMethod.GET)
    public Iterable<Secteur> getSecteurs()
    {
        return secteurRepository.findAll();
    }
}
