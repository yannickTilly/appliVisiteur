package LPY.appliVisiteur.Model.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class PeriodeTravaillee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Departement departement;

    @ManyToOne
    private Region region;

    public long getId() {
        return id;
    }

    public PeriodeTravaillee setId(long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public PeriodeTravaillee setUser(User user) {
        this.user = user;
        return this;
    }

    public Departement getDepartement() {
        return departement;
    }

    public PeriodeTravaillee setDepartement(Departement departement) {
        this.departement = departement;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public PeriodeTravaillee setRegion(Region region) {
        this.region = region;
        return this;
    }
}

