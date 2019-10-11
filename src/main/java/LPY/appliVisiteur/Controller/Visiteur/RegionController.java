package LPY.appliVisiteur.Controller.Visiteur;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Region;
import LPY.appliVisiteur.Model.Repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RegionController extends BaseController {
    @Autowired
    private RegionRepository regionRepository;

    @RequestMapping(value = "region/{id}", method = RequestMethod.GET)
    public Optional<Region> getRegion(@PathVariable("id") Long id)
    {
        return regionRepository.findById(id);
    }

    @RequestMapping(value = "regions", method = RequestMethod.GET)
    public Iterable<Region> getRegions()
    {
        return regionRepository.findAll();
    }
}
