package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.MedicamentView;
import LPY.appliVisiteur.Model.View.Visiteur.RapportVisiteView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Drugs")
public class Medicament {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({RapportVisiteView.RapportVisite.class, MedicamentView.Medicament.class})
    private long id;

    @Column(name = "name", length = 50)
    @JsonView({RapportVisiteView.RapportVisite.class, MedicamentView.Medicament.class})
    private String name;

    @Column(name = "description", length = 100)
    @JsonView({MedicamentView.Medicament.class})
    private String description;

    @OneToMany(mappedBy = "medicament")
    private Collection<PresentationMedicament> presentationMedicaments;

    public Medicament()
    {
        presentationMedicaments = new ArrayList<PresentationMedicament>();
    }

    public long getId() {
        return id;
    }

    public Medicament setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<PresentationMedicament> getPresentationMedicaments() {
        return presentationMedicaments;
    }

    public Medicament setPresentationMedicaments(Collection<PresentationMedicament> presentationMedicaments) {
        this.presentationMedicaments = presentationMedicaments;
        return this;
    }

    public String getName() {
        return name;
    }

    public Medicament setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Medicament setDescription(String description) {
        this.description = description;
        return this;
    }
}
