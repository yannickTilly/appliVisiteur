package LPY.appliVisiteur.Controller.Delegate;

import LPY.appliVisiteur.Controller.BaseController.DepartmentController;
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
@RequestMapping("delegate")
@RolesAllowed("ROLE_DELEGATE")
public class DelegateDepartmentController extends DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping(value = "department/{id}", method = RequestMethod.GET)
    @JsonView(DepartmentView.Departement.class)
    public Department getDepartment(@PathVariable("id") long id) throws RessouceNotFoundExeption {
        return super.getDepartment(id);
    }

    @RequestMapping(value = "departments", method = RequestMethod.GET)
    @JsonView(DepartmentView.Departement.class)
    public Collection<Department> getDepartments(){
        return super.getDepartments();
    }
}
