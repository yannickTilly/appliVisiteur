package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.DrugPresentationView;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Reports")
public class Report {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({ReportView.RapportVisite.class, ReportView.DelegueRapportVisite.class, DrugPresentationView.PresentationMedicament.class})
    private long id;

    @JsonView({ReportView.RapportVisite.class, ReportView.DelegueRapportVisite.class})
    @Column(name = "description", length = 100)
    private String description;

    @ManyToOne
    @JsonView({ReportView.DelegueRapportVisite.class, })
    private User user;

    @OneToMany(mappedBy = "report")
    @JsonView({ReportView.RapportVisite.class, ReportView.DelegueRapportVisite.class})
    private Collection<DrugPresentation> drugPresentations;

    @ManyToOne
    @JsonView({ReportView.RapportVisite.class, ReportView.DelegueRapportVisite.class})
    private Pratitionner pratitionner;

    @ManyToOne
    private Region region;

    @JsonView({ReportView.RapportVisite.class, ReportView.DelegueRapportVisite.class})
    @Column(name = "sample_number")
    private int sampleNumber;


    public String getDescription() {
        return description;
    }

    public Report setDescription(String description) {
        this.description = description;
        return this;
    }

    public Report()
    {
        drugPresentations = new ArrayList<DrugPresentation>();
    }
    public long getId() {
        return id;
    }

    public Report setId(long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Report setUser(User user) {
        this.user = user;
        return this;
    }

    public Collection<DrugPresentation> getDrugPresentations() {
        return drugPresentations;
    }

    public Report setDrugPresentations(Collection<DrugPresentation> drugPresentations) {
        this.drugPresentations = drugPresentations;
        return this;
    }

    public Pratitionner getPratitionner() {
        return pratitionner;
    }

    public Report setPratitionner(Pratitionner pratitionner) {
        this.pratitionner = pratitionner;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public Report setRegion(Region region) {
        this.region = region;
        return this;
    }

    public int getSampleNumber() {
        return sampleNumber;
    }

    public Report setSampleNumber(int sampleNumber) {
        this.sampleNumber = sampleNumber;
        return this;
    }
}
