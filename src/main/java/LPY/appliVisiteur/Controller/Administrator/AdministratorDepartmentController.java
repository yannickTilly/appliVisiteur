package LPY.appliVisiteur.Controller.Administrator;

import LPY.appliVisiteur.Controller.BaseController.BaseController;
import LPY.appliVisiteur.Model.Entity.Department;
import LPY.appliVisiteur.Model.Exception.RessouceNotFoundExeption;
import LPY.appliVisiteur.Model.Repository.DepartmentRepository;
import LPY.appliVisiteur.Model.View.Visiteur.DepartmentView;
import com.fasterxml.jackson.annotation.JsonView;
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
public class AdministratorDepartmentController extends BaseController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping(value = "department/{id}", method = RequestMethod.GET)
    @JsonView(DepartmentView.Departement.class)
    public Department getDepartment(@PathVariable("id") long id) throws RessouceNotFoundExeption {
        Department department = departmentRepository.findOneById(id);
        if (department == null)
        {
            throw new RessouceNotFoundExeption("department not found");
        }
        return department;
    }

    @RequestMapping(value = "departments", method = RequestMethod.GET)
    @JsonView(DepartmentView.Departement.class)
    public Collection<Department> getDepartments(){
        return (Collection<Department>) departmentRepository.findAll();
    }
}
