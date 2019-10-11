package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Medicament;
import LPY.appliVisiteur.Model.Repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MedicamentController extends BaseController {
    @Autowired
    private MedicamentRepository medicamentRepository;

    @RequestMapping(value = "medicament/{id}", method = RequestMethod.GET)
    public Optional<Medicament> getDepartement(@PathVariable("id") Long id)
    {
        return medicamentRepository.findById(id);
    }

    @RequestMapping(value = "medicaments", method = RequestMethod.GET)
    public Iterable<Medicament> getMedicaments()
    {
        return medicamentRepository.findAll();
    }
}
