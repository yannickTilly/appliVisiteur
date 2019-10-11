package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Departement;
import LPY.appliVisiteur.Model.Repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DepartementController extends BaseController {
    @Autowired
    private DepartementRepository departementRepository;

    @RequestMapping(value = "departement/{id}", method = RequestMethod.GET)
    public Optional<Departement> getDepartement(@PathVariable("id") Long id)
    {
        return departementRepository.findById(id);
    }

    @RequestMapping(value = "departements", method = RequestMethod.GET)
    public Iterable<Departement> getDepartements()
    {
        return departementRepository.findAll();
    }
}
