package LPY.appliVisiteur.Model.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class RapportVisite {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User user;

    @ManyToMany
    private Collection<Medicament> medicaments;

    @ManyToOne
    private Praticien praticiens;

    public long getId() {
        return id;
    }

    public RapportVisite setId(long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public RapportVisite setUser(User user) {
        this.user = user;
        return this;
    }

    public Collection<Medicament> getMedicaments() {
        return medicaments;
    }

    public RapportVisite setMedicaments(Collection<Medicament> medicaments) {
        this.medicaments = medicaments;
        return this;
    }

    public Praticien getPraticiens() {
        return praticiens;
    }

    public RapportVisite setPraticiens(Praticien praticiens) {
        this.praticiens = praticiens;
        return this;
    }
}
