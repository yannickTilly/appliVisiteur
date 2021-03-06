package LPY.appliVisiteur.Controller.Administrator;

import LPY.appliVisiteur.Controller.BaseController.BaseController;
import LPY.appliVisiteur.Model.Entity.Region;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.RegionRepository;
import LPY.appliVisiteur.Model.View.Visiteur.RegionView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("administrator")
@RolesAllowed("ROLE_ADMINISTRATOR")
public class AdministratorRegionController extends BaseController {
    @Autowired
    private RegionRepository regionRepository;

    @RequestMapping(value = "region/{id}", method = RequestMethod.GET)
    @JsonView(RegionView.Region.class)
    public Region getRegion(@PathVariable("id") Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        Region region = regionRepository.findOneById(id);
        if(region == null)
        {
            throw new RessouceNotFoundExeption("region not found");
        }
        return region;
    }

    @RequestMapping(value = "regions", method = RequestMethod.GET)
    @JsonView(RegionView.Region.class)
    public Iterable<Region> getRegions() throws JsonProcessingException {
        return regionRepository.findAll();
    }
}
