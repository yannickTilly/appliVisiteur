package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.*;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.MedicamentRepository;
import LPY.appliVisiteur.Model.Repository.PraticienRepository;
import LPY.appliVisiteur.Model.Repository.PresentationMedicamentRepository;
import LPY.appliVisiteur.Model.Repository.RapportVisiteRepository;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.PresentationMedicamentBody;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.RapportVisiteBody;
import LPY.appliVisiteur.Model.View.Visiteur.RapportVisiteView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("visiteur")
public class RapportVisiteController extends BaseController {
    @Autowired
    protected RapportVisiteRepository rapportVisiteRepository;

    @Autowired
    protected MedicamentRepository medicamentRepository;

    @Autowired
    protected PraticienRepository praticienRepository;

    @Autowired
    protected PresentationMedicamentRepository presentationMedicamentRepository;

    @RequestMapping(value = "rapportVisite/{id}", method = RequestMethod.GET)
    public String getRapportVisite(@PathVariable("id") Long id) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        RapportVisite rapportVisite = rapportVisiteRepository.findOneByUserAndId(this.getUser(),id);
        if (rapportVisite == null)
        {
            throw new RessouceNotFoundExeption("rapport visite not found");
        }
        else
        {
            return this.createResponse(rapportVisite, RapportVisiteView.RapportVisite.class);
        }

    }

    @RequestMapping(value = "rapportVisite/{id}", method = RequestMethod.DELETE)
    public String deleteRapportVisite(@PathVariable("id") Long id) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        RapportVisite rapportVisite = rapportVisiteRepository.findOneByUserAndId(this.getUser(),id);
        if (rapportVisite == null)
        {
            throw new RessouceNotFoundExeption("rapport visite not found");
        }
        else
        {
            rapportVisiteRepository.delete(rapportVisite);
            return this.createResponse(this.getUser().getRapportVisites(), RapportVisiteView.RapportVisite.class);
        }

    }

    @RequestMapping(value = "rapportVisites", method = RequestMethod.GET)
    public String getRapportVisites() throws UserNotFoundException, JsonProcessingException {
        User user = this.getUser();
        Collection<RapportVisite> rapportVisites = rapportVisiteRepository.findByUser(user);
        return this.createResponse(rapportVisites, RapportVisiteView.RapportVisite.class);
    }

    @RequestMapping(value = "rapportVisite", method = RequestMethod.POST)
    public String postRapportVisite(@RequestBody RapportVisiteBody rapportVisiteBody) throws UserNotFoundException, JsonProcessingException, RessouceNotFoundExeption {
        User user = this.getUser();
        RapportVisite rapportVisite = new RapportVisite();
        Collection<PresentationMedicament> presentationMedicaments= new ArrayList<PresentationMedicament>();
        for (Long medicamentId : rapportVisiteBody.getMedicamentId()) {
            Medicament medicament = medicamentRepository.findOneById(medicamentId);
            if (medicament != null)
            {
                PresentationMedicament presentationMedicament = new PresentationMedicament();
                presentationMedicament.setMedicament(medicament)
                        .setRapportVisite(rapportVisite);
                presentationMedicaments.add(presentationMedicament);
            }
            else
            {
                throw new RessouceNotFoundExeption("medicament not found");
            }
        }
        Praticien praticien = praticienRepository.findOneById(rapportVisiteBody.getPraticienId());
        if (praticien != null)
        {
            rapportVisite.setPraticien(praticien);
        }
        else
        {
            throw new RessouceNotFoundExeption("praticien not found");
        }

        rapportVisite.setUser(user);
        rapportVisite.setPresentationMedicaments(presentationMedicaments);
        rapportVisite.setDescription(rapportVisiteBody.getNote());
        rapportVisiteRepository.save(rapportVisite);
        presentationMedicamentRepository.saveAll(presentationMedicaments);
        return this.createResponse(rapportVisite, RapportVisiteView.RapportVisite.class);
    }

    @RequestMapping(value = "rapportVisite/{id}", method = RequestMethod.PATCH)
    public String patchRapportVisite(@PathVariable("id") Long id, @RequestBody RapportVisiteBody rapportVisiteBody) throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException {
        RapportVisite rapportVisite = rapportVisiteRepository.findOneByUserAndId(this.getUser(),id);
        if (rapportVisite == null)
        {
            throw new RessouceNotFoundExeption("rapport visite not found");
        }
        else
        {
            if (rapportVisiteBody.getNote() != null)
            {
                rapportVisite.setDescription(rapportVisiteBody.getNote());
            }
            rapportVisiteRepository.save(rapportVisite);
            return this.createResponse(rapportVisite, RapportVisiteView.RapportVisite.class);
        }

    }
}
