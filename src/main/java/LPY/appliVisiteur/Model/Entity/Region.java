package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.PeriodeTravailleeView;
import LPY.appliVisiteur.Model.View.Visiteur.RegionView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Region {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView({PeriodeTravailleeView.PeriodeTravaille.class, UserView.User.class, RegionView.Region.class})
    private long id;

    @OneToMany
    private Collection<PeriodeTravaillee> periodeTravaillees;

    @ManyToOne
    @JsonView(UserView.User.class)
    private Secteur secteur;

    @OneToMany(mappedBy = "region")
    private Collection<User> delegues;

    @OneToMany(mappedBy = "region")
    private Collection<RapportVisite> rapportVisites;



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

    public Collection<User> getDelegues() {
        return delegues;
    }

    public Region setDelegues(Collection<User> delegues) {
        this.delegues = delegues;
        return this;
    }

    public Collection<RapportVisite> getRapportVisites() {
        return rapportVisites;
    }

    public Region setRapportVisites(Collection<RapportVisite> rapportVisites) {
        this.rapportVisites = rapportVisites;
        return this;
    }
}
