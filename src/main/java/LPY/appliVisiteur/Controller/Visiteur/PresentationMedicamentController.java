package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Medicament;
import LPY.appliVisiteur.Model.Entity.PresentationMedicament;
import LPY.appliVisiteur.Model.Entity.RapportVisite;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Exception.UserNotFoundException;
import LPY.appliVisiteur.Model.Repository.MedicamentRepository;
import LPY.appliVisiteur.Model.Repository.PraticienRepository;
import LPY.appliVisiteur.Model.Repository.PresentationMedicamentRepository;
import LPY.appliVisiteur.Model.Repository.RapportVisiteRepository;
import LPY.appliVisiteur.Model.RequestBody.Visiteur.PresentationMedicamentBody;
import LPY.appliVisiteur.Model.View.Visiteur.RapportVisiteView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PresentationMedicamentController extends BaseController {
    @Autowired
    private RapportVisiteRepository rapportVisiteRepository;

    @Autowired
    private MedicamentRepository medicamentRepository;

    @Autowired
    private PraticienRepository praticienRepository;

    @Autowired
    private PresentationMedicamentRepository presentationMedicamentRepository;

    @RequestMapping(value = "presentationMedicament", method = RequestMethod.POST)
    public String patchMedicament(@RequestBody PresentationMedicamentBody presentationMedicamentBody)
            throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException
    {
        RapportVisite rapportVisite = rapportVisiteRepository.findOneByUserAndId(this.getUser(),presentationMedicamentBody.getIdRapportVisite());
        Medicament medicament = medicamentRepository.findOneById(presentationMedicamentBody.getIdMedicament());
        if (rapportVisite == null || medicament == null)
        {
            throw new RessouceNotFoundExeption("rapport visite or medicament not found");
        }
        else
        {
            PresentationMedicament presentationMedicament = new PresentationMedicament();
            presentationMedicament.setRapportVisite(rapportVisite);
            presentationMedicament.setMedicament(medicament);
            rapportVisite.getPresentationMedicaments().add(presentationMedicament);
            presentationMedicamentRepository.save(presentationMedicament);
            return this.createResponse(rapportVisite, RapportVisiteView.rapportVisite.class);
        }
    }

    @RequestMapping(value = "presentationMedicament/{idPresentationMedicament}", method = RequestMethod.DELETE)
    public String deleteMedicament(@PathVariable("idPresentationMedicament") Long idPresentationMedicament)
            throws UserNotFoundException, RessouceNotFoundExeption, JsonProcessingException
    {
        PresentationMedicament presentationMedicament = presentationMedicamentRepository.findOneById(idPresentationMedicament);
        if (presentationMedicament == null)
        {
            throw new RessouceNotFoundExeption("presentation medicament not found");
        }
        else
        {
            presentationMedicamentRepository.delete(presentationMedicament);
            return this.createResponse(presentationMedicament.getRapportVisite(), RapportVisiteView.rapportVisite.class);
        }

    }
}
