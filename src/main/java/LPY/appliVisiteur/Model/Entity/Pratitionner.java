package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.PratitionnerView;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Pratitionners")
public class Pratitionner {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({ReportView.RapportVisite.class, PratitionnerView.Praticien.class})
    private long id;

    @OneToMany(mappedBy = "pratitionner")
    private Collection<Report> reports;

    @ManyToMany
    @JoinTable(
            name = "diploma_pratitionners")
    @JsonView(PratitionnerView.Praticien.class)
    private Collection<Diploma> diplomas;

    @Column(name = "first_name", length = 50)
    @JsonView({ReportView.RapportVisite.class, PratitionnerView.Praticien.class})
    private String first_name;

    public long getId() {
        return id;
    }

    public Pratitionner setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<Report> getReports() {
        return reports;
    }

    public Pratitionner setReports(Collection<Report> reports) {
        this.reports = reports;
        return this;
    }

    public Collection<Diploma> getDiplomas() {
        return diplomas;
    }

    public Pratitionner setDiplomas(Collection<Diploma> diplomas) {
        this.diplomas = diplomas;
        return this;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Pratitionner setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }
}
