package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.PraticienView;
import LPY.appliVisiteur.Model.View.Visiteur.RapportVisiteView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Pratitionners")
public class Praticien {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({RapportVisiteView.RapportVisite.class, PraticienView.Praticien.class})
    private long id;

    @OneToMany(mappedBy = "praticien")
    private Collection<RapportVisite> rapportVisites;

    @ManyToMany
    @JoinTable(
            name = "diploma_pratitionners")
    @JsonView(PraticienView.Praticien.class)
    private Collection<Diplome> diplomes;

    @Column(name = "first_name", length = 50)
    private String first_name;

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

    public String getFirst_name() {
        return first_name;
    }

    public Praticien setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }
}
