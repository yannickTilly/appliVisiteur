package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.RapportVisiteView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class RapportVisite {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView(RapportVisiteView.rapportVisite.class)
    private long id;

    @JsonView(RapportVisiteView.rapportVisite.class)
    private String note;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "rapportVisite")
    @JsonView(RapportVisiteView.rapportVisite.class)
    private Collection<PresentationMedicament> presentationMedicaments;

    @ManyToOne
    @JsonView(RapportVisiteView.rapportVisite.class)
    private Praticien praticien;

    public String getNote() {
        return note;
    }

    public RapportVisite setNote(String note) {
        this.note = note;
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
}
