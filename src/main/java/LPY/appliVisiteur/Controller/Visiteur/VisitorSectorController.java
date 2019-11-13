package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Sector;
import LPY.appliVisiteur.Model.Repository.SecteurRepository;
import LPY.appliVisiteur.Model.View.Visiteur.SectorView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("visitor")
public class VisitorSectorController extends BaseController {
    @Autowired
    private SecteurRepository secteurRepository;

    @RequestMapping(value = "sector/{id}", method = RequestMethod.GET)
    public String getSecteur(@PathVariable("id") Long id) throws JsonProcessingException {
        Sector sector = secteurRepository.findOneById(id);
        return createResponse(sector, SectorView.Secteur.class);
    }

    @RequestMapping(value = "sectors", method = RequestMethod.GET)
    public String getSecteurs() throws JsonProcessingException {
        return createResponse(secteurRepository.findAll(), SectorView.Secteur.class);
    }
}
