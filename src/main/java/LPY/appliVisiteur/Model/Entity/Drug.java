package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.DrugView;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Drugs")
public class Drug {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({ReportView.RapportVisite.class, DrugView.Medicament.class})
    private long id;

    @Column(name = "name", length = 50)
    @JsonView({ReportView.RapportVisite.class, DrugView.Medicament.class})
    private String name;

    @Column(name = "description", length = 100)
    @JsonView({DrugView.Medicament.class})
    private String description;

    @OneToMany(mappedBy = "drug")
    private Collection<DrugPresentation> drugPresentations;

    public Drug()
    {
        drugPresentations = new ArrayList<DrugPresentation>();
    }

    public long getId() {
        return id;
    }

    public Drug setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<DrugPresentation> getDrugPresentations() {
        return drugPresentations;
    }

    public Drug setDrugPresentations(Collection<DrugPresentation> drugPresentations) {
        this.drugPresentations = drugPresentations;
        return this;
    }

    public String getName() {
        return name;
    }

    public Drug setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Drug setDescription(String description) {
        this.description = description;
        return this;
    }
}
