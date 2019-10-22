package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.DepartementView;
import LPY.appliVisiteur.Model.View.Visiteur.DiplomeView;
import LPY.appliVisiteur.Model.View.Visiteur.PraticienView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Diplomas")
public class Diplome {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({PraticienView.Praticien.class, DiplomeView.Diplome.class})
    private long id;

    @Column(name = "name")
    @JsonView({PraticienView.Praticien.class, DiplomeView.Diplome.class})
    private String name;

    @Column(name = "speciality")
    @JsonView({PraticienView.Praticien.class, DiplomeView.Diplome.class})
    private String speciality;

    @ManyToMany(mappedBy = "diplomes")
    private Collection<Praticien> praticiens;

    public long getId() {
        return id;
    }

    public Diplome setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Diplome setName(String name) {
        this.name = name;
        return this;
    }

    public String getSpeciality() {
        return speciality;
    }

    public Diplome setSpeciality(String speciality) {
        this.speciality = speciality;
        return this;
    }

    public Collection<Praticien> getPraticiens() {
        return praticiens;
    }

    public Diplome setPraticiens(Collection<Praticien> praticiens) {
        this.praticiens = praticiens;
        return this;
    }
}
