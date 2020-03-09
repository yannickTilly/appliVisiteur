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
    @JsonView({ReportView.Report.class, PratitionnerView.Praticien.class})
    private long id;

    @OneToMany(mappedBy = "pratitionner")
    private Collection<Report> reports;

    @ManyToMany
    @JoinTable(
            name = "diploma_pratitionners")
    @JsonView(PratitionnerView.Praticien.class)
    private Collection<Diploma> diplomas;

    @Column(name = "first_name", length = 50)
    @JsonView({ReportView.Report.class, PratitionnerView.Praticien.class})
    private String firstName;

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

    public String getFirstName() {
        return firstName;
    }

    public Pratitionner setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}
