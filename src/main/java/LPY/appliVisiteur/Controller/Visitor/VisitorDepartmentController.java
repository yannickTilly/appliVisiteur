package LPY.appliVisiteur.Controller.Visitor;

import LPY.appliVisiteur.Controller.BaseController;
import LPY.appliVisiteur.Model.Entity.Department;
import LPY.appliVisiteur.Model.Exception.RessourceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.DepartmentRepository;
import LPY.appliVisiteur.Model.View.Visiteur.DepartmentView;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("visitor")
public class VisitorDepartmentController extends BaseController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping(value = "department/{id}", method = RequestMethod.GET)
    public String getDepartment(@PathVariable("id") long id) throws JsonProcessingException, RessourceNotFoundExeption {
        Department department = departmentRepository.findOneById(id);
        if (department == null)
        {
            throw new RessourceNotFoundExeption("department not found");
        }
        return this.createResponse(department, DepartmentView.Departement.class);
    }

    @RequestMapping(value = "departments", method = RequestMethod.GET)
    public String getDepartments() throws JsonProcessingException {
        return this.createResponse(departmentRepository.findAll(), DepartmentView.Departement.class);
    }
}
