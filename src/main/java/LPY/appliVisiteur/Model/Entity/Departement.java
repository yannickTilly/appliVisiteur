package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.DepartementView;
import LPY.appliVisiteur.Model.View.Visiteur.PeriodeTravailleeView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Departments")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({PeriodeTravailleeView.PeriodeTravaille.class, UserView.User.class, DepartementView.Departement.class})
    private long id;

    @Column(name = "code", length = 10)
    @JsonView({PeriodeTravailleeView.PeriodeTravaille.class, UserView.User.class, DepartementView.Departement.class})
    private String code;

    @Column(name = "name", length = 30)
    @JsonView({PeriodeTravailleeView.PeriodeTravaille.class, UserView.User.class, DepartementView.Departement.class})
    private String name;

    @OneToMany(mappedBy = "departement")
    private Collection<PeriodeTravaillee> periodeTravaillees;

    public long getId() {
        return id;
    }

    public Departement setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<PeriodeTravaillee> getPeriodeTravaillees() {
        return periodeTravaillees;
    }

    public Departement setPeriodeTravaillees(Collection<PeriodeTravaillee> periodeTravaillees) {
        this.periodeTravaillees = periodeTravaillees;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Departement setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Departement setName(String name) {
        this.name = name;
        return this;
    }
}
