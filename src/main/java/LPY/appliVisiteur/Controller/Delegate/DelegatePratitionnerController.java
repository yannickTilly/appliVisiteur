package LPY.appliVisiteur.Controller.Delegate;

import LPY.appliVisiteur.Controller.BaseController.PratitionnerController;
import LPY.appliVisiteur.Model.Entity.Pratitionner;
import LPY.appliVisiteur.Model.Repository.PraticionnerRepository;
import LPY.appliVisiteur.Model.View.Visiteur.PratitionnerView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Collection;

@RestController
@RequestMapping("delegate")
@RolesAllowed("ROLE_DELEGATE")
public class DelegatePratitionnerController extends PratitionnerController {
    @Autowired
    private PraticionnerRepository praticionnerRepository;

    @RequestMapping(value = "pratitionners", method = RequestMethod.GET)
    @JsonView(PratitionnerView.Praticien.class)
    public Collection<Pratitionner> getPratitionners() throws JsonProcessingException {
        return super.getPratitionners();
    }
}
