package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.DiplomaView;
import LPY.appliVisiteur.Model.View.Visiteur.PratitionnerView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Diplomas")
public class Diploma {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({PratitionnerView.Praticien.class, DiplomaView.Diplome.class})
    private long id;

    @Column(name = "name")
    @JsonView({PratitionnerView.Praticien.class, DiplomaView.Diplome.class})
    private String name;

    @Column(name = "speciality")
    @JsonView({PratitionnerView.Praticien.class, DiplomaView.Diplome.class})
    private String speciality;

    @ManyToMany(mappedBy = "diplomas")
    private Collection<Pratitionner> pratitionners;

    public long getId() {
        return id;
    }

    public Diploma setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Diploma setName(String name) {
        this.name = name;
        return this;
    }

    public String getSpeciality() {
        return speciality;
    }

    public Diploma setSpeciality(String speciality) {
        this.speciality = speciality;
        return this;
    }

    public Collection<Pratitionner> getPratitionners() {
        return pratitionners;
    }

    public Diploma setPratitionners(Collection<Pratitionner> pratitionners) {
        this.pratitionners = pratitionners;
        return this;
    }
}
