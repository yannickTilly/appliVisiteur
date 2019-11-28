package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.DepartmentView;
import LPY.appliVisiteur.Model.View.Visiteur.WorkedTimeView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({WorkedTimeView.PeriodeTravaille.class, UserView.User.class, DepartmentView.Departement.class})
    private long id;

    @Column(name = "code", length = 10)
    @JsonView({WorkedTimeView.PeriodeTravaille.class, UserView.User.class, DepartmentView.Departement.class})
    private String code;

    @Column(name = "name", length = 30)
    @JsonView({WorkedTimeView.PeriodeTravaille.class, UserView.User.class, DepartmentView.Departement.class})
    private String name;

    @OneToMany(mappedBy = "department")
    private Collection<WorkedTime> workedTimes;

    public long getId() {
        return id;
    }

    public Department setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<WorkedTime> getWorkedTimes() {
        return workedTimes;
    }

    public Department setWorkedTimes(Collection<WorkedTime> workedTimes) {
        this.workedTimes = workedTimes;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Department setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }
}
