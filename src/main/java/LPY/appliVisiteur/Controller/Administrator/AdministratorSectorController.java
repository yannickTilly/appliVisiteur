package LPY.appliVisiteur.Controller.Administrator;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Sector;
import LPY.appliVisiteur.Model.Repository.SecteurRepository;
import LPY.appliVisiteur.Model.View.Visiteur.SectorView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("visitor")
public class AdministratorSectorController extends BaseController {
    @Autowired
    private SecteurRepository secteurRepository;

    @RequestMapping(value = "sector/{id}", method = RequestMethod.GET)
    @JsonView(SectorView.Secteur.class)
    public Sector getSector(@PathVariable("id") Long id) throws JsonProcessingException {
        Sector sector = secteurRepository.findOneById(id);
        return sector;
    }

    @RequestMapping(value = "sectors", method = RequestMethod.GET)
    @JsonView(SectorView.Secteur.class)
    public Iterable<Sector> getSectors() throws JsonProcessingException {
        return secteurRepository.findAll();
    }
}
