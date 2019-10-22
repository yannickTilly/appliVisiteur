package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Secteur;
import LPY.appliVisiteur.Model.Repository.SecteurRepository;
import LPY.appliVisiteur.Model.View.Visiteur.SecteurView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("visiteur")
public class SecteurController extends BaseController {
    @Autowired
    private SecteurRepository secteurRepository;

    @RequestMapping(value = "secteur/{id}", method = RequestMethod.GET)
    public String getSecteur(@PathVariable("id") Long id) throws JsonProcessingException {
        Secteur secteur = secteurRepository.findOneById(id);
        return createResponse(secteur, SecteurView.Secteur.class);
    }

    @RequestMapping(value = "secteurs", method = RequestMethod.GET)
    public String getSecteurs() throws JsonProcessingException {
        return createResponse(secteurRepository.findAll(), SecteurView.Secteur.class);
    }
}
