package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.BaseController.BaseController;
import LPY.appliVisiteur.Controller.BaseController.SectorController;
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

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("administrator")
@RolesAllowed("ROLE_ADMINISTRATOR")
public class VisitorSectorController extends SectorController {
    @Autowired
    private SecteurRepository secteurRepository;

    @RequestMapping(value = "sector/{id}", method = RequestMethod.GET)
    @JsonView(SectorView.Secteur.class)
    public Sector getSector(@PathVariable("id") Long id) throws JsonProcessingException {
        return super.getSector(id);
    }

    @RequestMapping(value = "sectors", method = RequestMethod.GET)
    @JsonView(SectorView.Secteur.class)
    public Iterable<Sector> getSectors() throws JsonProcessingException {
        return super.getSectors();
    }
}
