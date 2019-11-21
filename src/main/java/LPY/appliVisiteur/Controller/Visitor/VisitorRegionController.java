package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Region;
import LPY.appliVisiteur.Model.Exception.RessourceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.RegionRepository;
import LPY.appliVisiteur.Model.View.Visiteur.RegionView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("visitor")
public class VisitorRegionController extends BaseController {
    @Autowired
    private RegionRepository regionRepository;

    @RequestMapping(value = "region/{id}", method = RequestMethod.GET)
    public String getRegion(@PathVariable("id") Long id) throws JsonProcessingException, RessourceNotFoundExeption {
        Region region = regionRepository.findOneById(id);
        if(region == null)
        {
            throw new RessourceNotFoundExeption("region not found");
        }
        return createResponse(region, RegionView.Region.class);
    }

    @RequestMapping(value = "regions", method = RequestMethod.GET)
    public String getRegions() throws JsonProcessingException {
        return createResponse(regionRepository.findAll(), RegionView.Region.class);
    }
}