package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Diplome;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.DiplomeRepository;
import LPY.appliVisiteur.Model.View.Visiteur.DiplomeView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("visiteur")
public class DiplomeController extends BaseController {
    @Autowired
    private DiplomeRepository diplomeRepository;

    @RequestMapping(value = "diplome/{id}", method = RequestMethod.GET)
    public String getDiplome(@PathVariable("id") Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Diplome diplome = diplomeRepository.findOneById(id);
        if (diplome == null)
        {
            throw new RessouceNotFoundExeption("diplome not found");
        }
        return this.createResponse(diplomeRepository.findOneById(id),DiplomeView.Diplome.class);
    }

    @RequestMapping(value = "diplomes", method = RequestMethod.GET)
    public String getDiplomes() throws JsonProcessingException {
        return this.createResponse(diplomeRepository.findAll(),DiplomeView.Diplome.class);
    }
}
