package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Diplome;
import LPY.appliVisiteur.Model.Repository.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DiplomeController extends BaseController {
    @Autowired
    private DiplomeRepository diplomeRepository;

    @RequestMapping(value = "diplome/{id}", method = RequestMethod.GET)
    public Optional<Diplome> getDiplome(@PathVariable("id") Long id)
    {
        return diplomeRepository.findById(id);
    }

    @RequestMapping(value = "diplomes", method = RequestMethod.GET)
    public Iterable<Diplome> getDiplomes()
    {
        return diplomeRepository.findAll();
    }
}
