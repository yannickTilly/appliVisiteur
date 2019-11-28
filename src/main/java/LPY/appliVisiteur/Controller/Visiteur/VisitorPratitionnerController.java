package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Pratitionner;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.PraticionnerRepository;
import LPY.appliVisiteur.Model.View.Visiteur.PratitionnerView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("visitor")
public class VisitorPratitionnerController extends BaseController {
    @Autowired
    private PraticionnerRepository praticionnerRepository;

    @RequestMapping(value = "pratitionner/{id}", method = RequestMethod.GET)
    public String getDepartment(@PathVariable("id") Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Pratitionner pratitionner = praticionnerRepository.findOneById(id);
        if (pratitionner == null)
        {
            throw new RessouceNotFoundExeption("pratitionner not found");
        }
        return createResponse(pratitionner, PratitionnerView.Praticien.class);
    }

    @RequestMapping(value = "pratitionners", method = RequestMethod.GET)
    public String getPratitionners() throws JsonProcessingException {
        return createResponse(praticionnerRepository.findAll(), PratitionnerView.Praticien.class);
    }
}
