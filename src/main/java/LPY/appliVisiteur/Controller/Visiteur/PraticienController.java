package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Praticien;
import LPY.appliVisiteur.Model.Repository.PraticienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PraticienController extends BaseController {
    @Autowired
    private PraticienRepository praticienRepository;

    @RequestMapping(value = "praticien/{id}", method = RequestMethod.GET)
    public Praticien getDepartement(@PathVariable("id") Long id)
    {
        return praticienRepository.findOneById(id);
    }

    @RequestMapping(value = "praticiens", method = RequestMethod.GET)
    public Iterable<Praticien> getPraticiens()
    {
        return praticienRepository.findAll();
    }
}
