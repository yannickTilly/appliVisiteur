package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.RapportVisiteView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Reports")
public class RapportVisite {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({RapportVisiteView.RapportVisite.class, RapportVisiteView.DelegueRapportVisite.class})
    private long id;

    @JsonView({RapportVisiteView.RapportVisite.class, RapportVisiteView.DelegueRapportVisite.class})
    @Column(name = "description", length = 100)
    private String description;

    @ManyToOne
    @JsonView({RapportVisiteView.DelegueRapportVisite.class, })
    private User user;

    @OneToMany(mappedBy = "rapportVisite")
    @JsonView({RapportVisiteView.RapportVisite.class, RapportVisiteView.DelegueRapportVisite.class})
    private Collection<PresentationMedicament> presentationMedicaments;

    @ManyToOne
    @JsonView({RapportVisiteView.RapportVisite.class, RapportVisiteView.DelegueRapportVisite.class})
    private Praticien praticien;

    @ManyToOne
    private Region region;

    @JsonView({RapportVisiteView.RapportVisite.class, RapportVisiteView.DelegueRapportVisite.class})
    @Column(name = "sample_number")
    private int sampleNumber;


    public String getDescription() {
        return description;
    }

    public RapportVisite setDescription(String description) {
        this.description = description;
        return this;
    }

    public RapportVisite()
    {
        presentationMedicaments = new ArrayList<PresentationMedicament>();
    }
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

    public Collection<PresentationMedicament> getPresentationMedicaments() {
        return presentationMedicaments;
    }

    public RapportVisite setPresentationMedicaments(Collection<PresentationMedicament> presentationMedicaments) {
        this.presentationMedicaments = presentationMedicaments;
        return this;
    }

    public Praticien getPraticien() {
        return praticien;
    }

    public RapportVisite setPraticien(Praticien praticien) {
        this.praticien = praticien;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public RapportVisite setRegion(Region region) {
        this.region = region;
        return this;
    }

    public int getSampleNumber() {
        return sampleNumber;
    }

    public RapportVisite setSampleNumber(int sampleNumber) {
        this.sampleNumber = sampleNumber;
        return this;
    }
}
