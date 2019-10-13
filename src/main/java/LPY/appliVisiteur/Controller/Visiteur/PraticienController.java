package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Praticien;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.PraticienRepository;
import LPY.appliVisiteur.Model.View.Visiteur.PraticienView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PraticienController extends BaseController {
    @Autowired
    private PraticienRepository praticienRepository;

    @RequestMapping(value = "praticien/{id}", method = RequestMethod.GET)
    public String getDepartement(@PathVariable("id") Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Praticien praticien = praticienRepository.findOneById(id);
        if (praticien == null)
        {
            throw new RessouceNotFoundExeption("praticien not found");
        }
        return createResponse(praticien, PraticienView.Praticien.class);
    }

    @RequestMapping(value = "praticiens", method = RequestMethod.GET)
    public String getPraticiens() throws JsonProcessingException {
        return createResponse(praticienRepository.findAll(), PraticienView.Praticien.class);
    }
}
