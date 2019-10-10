package LPY.appliVisiteur.Model.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Praticien {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @OneToMany
    private Collection<RapportVisite> rapportVisites;

    @OneToMany
    private Collection<Diplome> diplomes;

    public long getId() {
        return id;
    }

    public Praticien setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<RapportVisite> getRapportVisites() {
        return rapportVisites;
    }

    public Praticien setRapportVisites(Collection<RapportVisite> rapportVisites) {
        this.rapportVisites = rapportVisites;
        return this;
    }

    public Collection<Diplome> getDiplomes() {
        return diplomes;
    }

    public Praticien setDiplomes(Collection<Diplome> diplomes) {
        this.diplomes = diplomes;
        return this;
    }
}
