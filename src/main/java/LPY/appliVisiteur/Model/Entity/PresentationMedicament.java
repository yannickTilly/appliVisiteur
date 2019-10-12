package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.RapportVisiteView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
public class PresentationMedicament {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonView(RapportVisiteView.rapportVisite.class)
    private long id;

    @ManyToOne
    @JsonView(RapportVisiteView.rapportVisite.class)
    private Medicament medicament;

    @ManyToOne
    private  RapportVisite rapportVisite;

    public Medicament getMedicament() {
        return medicament;
    }

    public PresentationMedicament setMedicament(Medicament medicament) {
        this.medicament = medicament;
        return this;
    }

    public RapportVisite getRapportVisite() {
        return rapportVisite;
    }

    public PresentationMedicament setRapportVisite(RapportVisite rapportVisite) {
        this.rapportVisite = rapportVisite;
        return this;
    }
}
