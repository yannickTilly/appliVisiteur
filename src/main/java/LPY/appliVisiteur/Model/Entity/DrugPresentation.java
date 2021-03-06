package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.DrugPresentationView;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "DrugPresentations")
public class DrugPresentation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({ReportView.Report.class, DrugPresentationView.DrugPresentation.class, ReportView.DelegueRapportVisite.class})
    private long id;

    @JsonView({DrugPresentationView.DrugPresentation.class, ReportView.DelegueRapportVisite.class})
    private String note;

    @ManyToOne
    @JsonView({ReportView.Report.class, DrugPresentationView.DrugPresentation.class, ReportView.DelegueRapportVisite.class})
    private Drug drug;

    @ManyToOne
    @JsonView(DrugPresentationView.DrugPresentation.class)
    private Report report;

    @JsonView({DrugPresentationView.DrugPresentation.class, ReportView.Report.class, ReportView.DelegueRapportVisite.class})
    private String label;

    public long getId() {
        return id;
    }

    public DrugPresentation setId(long id) {
        this.id = id;
        return this;
    }

    public String getNote() {
        return note;
    }

    public DrugPresentation setNote(String note) {
        this.note = note;
        return this;
    }

    public Drug getDrug() {
        return drug;
    }

    public DrugPresentation setDrug(Drug drug) {
        this.drug = drug;
        return this;
    }

    public Report getReport() {
        return report;
    }

    public DrugPresentation setReport(Report report) {
        this.report = report;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public DrugPresentation setLabel(String label) {
        this.label = label;
        return this;
    }
}
