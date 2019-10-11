package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.PeriodeTravaillee;
import LPY.appliVisiteur.Model.Repository.PeriodeTravailleeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PeriodeTravailleeController extends BaseController {
    @Autowired
    private PeriodeTravailleeRepository periodeTravailleeRepository;

    @RequestMapping(value = "periodeTravaillee/{id}", method = RequestMethod.GET)
    public Optional<PeriodeTravaillee> getDepartement(@PathVariable("id") Long id)
    {
        return periodeTravailleeRepository.findById(id);
    }

    @RequestMapping(value = "periodeTravaillees", method = RequestMethod.GET)
    public Iterable<PeriodeTravaillee> getPeriodeTravaillees()
    {
        return periodeTravailleeRepository.findAll();
    }
}
