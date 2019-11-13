package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Diploma;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.DiplomaRepository;
import LPY.appliVisiteur.Model.View.Visiteur.DiplomaView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("visitor")
public class VisitorDiplomaController extends BaseController {
    @Autowired
    private DiplomaRepository diplomaRepository;

    @RequestMapping(value = "diploma/{id}", method = RequestMethod.GET)
    public String getDiplome(@PathVariable("id") Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Diploma diploma = diplomaRepository.findOneById(id);
        if (diploma == null)
        {
            throw new RessouceNotFoundExeption("diploma not found");
        }
        return this.createResponse(diplomaRepository.findOneById(id), DiplomaView.Diplome.class);
    }

    @RequestMapping(value = "diplomas", method = RequestMethod.GET)
    public String getDiplomes() throws JsonProcessingException {
        return this.createResponse(diplomaRepository.findAll(), DiplomaView.Diplome.class);
    }
}
