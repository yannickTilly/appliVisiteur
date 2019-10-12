package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.RapportVisiteView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Medicament {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView(RapportVisiteView.rapportVisite.class)
    private long id;

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
}
