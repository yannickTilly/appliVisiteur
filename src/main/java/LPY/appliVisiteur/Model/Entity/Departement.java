package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.PeriodeTravailleeView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({PeriodeTravailleeView.periodeTravaille.class, UserView.user.class})
    private long id;

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
}
