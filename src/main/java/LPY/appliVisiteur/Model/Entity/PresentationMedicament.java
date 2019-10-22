package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.PraticienView;
import LPY.appliVisiteur.Model.View.Visiteur.PresentationMedicamentView;
import LPY.appliVisiteur.Model.View.Visiteur.RapportVisiteView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "DrugPresentations")
public class PresentationMedicament {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({RapportVisiteView.RapportVisite.class, PresentationMedicamentView.PresentationMedicament.class})
    private long id;

    @ManyToOne
    @JsonView({RapportVisiteView.RapportVisite.class, PresentationMedicamentView.PresentationMedicament.class})
    private Medicament medicament;

    @ManyToOne
    @JsonView(PresentationMedicamentView.PresentationMedicament.class)
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
