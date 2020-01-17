package LPY.appliVisiteur.Controller.Delegate;

import LPY.appliVisiteur.Controller.BaseController.RegionController;
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
import java.util.Collection;

@RestController
@RequestMapping("administrator")
@RolesAllowed("ROLE_ADMINISTRATOR")
public class DelegateRegionController extends RegionController {
    @Autowired
    private RegionRepository regionRepository;

    @RequestMapping(value = "region/{id}", method = RequestMethod.GET)
    @JsonView(RegionView.Region.class)
    public Region getRegion(@PathVariable("id") Long id) throws JsonProcessingException, RessouceNotFoundExeption {
        return super.getRegion(id);
    }

    @RequestMapping(value = "regions", method = RequestMethod.GET)
    @JsonView(RegionView.Region.class)
    public Collection<Region> getRegions() throws JsonProcessingException {
        return super.getRegions();
    }
}
