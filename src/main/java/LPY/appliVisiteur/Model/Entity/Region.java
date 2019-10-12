package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.PeriodeTravailleeView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Region {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView({PeriodeTravailleeView.periodeTravaille.class, UserView.user.class})
    private long id;

    @OneToMany
    private Collection<PeriodeTravaillee> periodeTravaillees;

    @ManyToOne
    @JsonView(UserView.user.class)
    private Secteur secteur;

    public long getId() {
        return id;
    }

    public Region setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<PeriodeTravaillee> getPeriodeTravaillees() {
        return periodeTravaillees;
    }

    public Region setPeriodeTravaillees(Collection<PeriodeTravaillee> periodeTravaillees) {
        this.periodeTravaillees = periodeTravaillees;
        return this;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public Region setSecteur(Secteur secteur) {
        this.secteur = secteur;
        return this;
    }
}
