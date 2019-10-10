package LPY.appliVisiteur.Model.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Region {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @OneToMany
    private Collection<Region> regions;

    @ManyToOne
    private Secteur secteur;

    public long getId() {
        return id;
    }

    public Region setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<Region> getRegions() {
        return regions;
    }

    public Region setRegions(Collection<Region> regions) {
        this.regions = regions;
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
