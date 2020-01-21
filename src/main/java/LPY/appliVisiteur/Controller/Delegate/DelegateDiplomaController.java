package LPY.appliVisiteur.Controller.Delegate;

import LPY.appliVisiteur.Controller.BaseController.DiplomaController;
import LPY.appliVisiteur.Model.Entity.Diploma;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.DiplomaRepository;
import LPY.appliVisiteur.Model.View.Visiteur.DiplomaView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("delegate")
@RolesAllowed("ROLE_DELEGATE")
public class DelegateDiplomaController extends DiplomaController {
    @Autowired
    private DiplomaRepository diplomaRepository;

    @RequestMapping(value = "diploma/{id}", method = RequestMethod.GET)
    @JsonView(DiplomaView.Diplome.class)
    public Diploma getDiploma(@PathVariable("id") Long id) throws RessouceNotFoundExeption, JsonProcessingException {
        return super.getDiploma(id);
    }

    @RequestMapping(value = "diplomas", method = RequestMethod.GET)
    @JsonView(DiplomaView.Diplome.class)
    public Iterable<Diploma> getDiplomas() throws JsonProcessingException {
        return super.getDiplomas();
    }
}
