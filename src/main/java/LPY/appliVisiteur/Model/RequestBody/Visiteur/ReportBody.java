package LPY.appliVisiteur.Model.RequestBody.Visiteur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class ReportBody {
    private Collection<Long> medicamentIds;
    private Long praticienId;
    private String note;
    private String label;
    private int sampleNumber;
    private String date;

    public String getDate() {
        return date;
    }

    public ReportBody setDate(String date) {
        this.date = date;
        return this;
    }

    public Collection<Long> getMedicamentIds() {
        return medicamentIds;
    }

    public ReportBody setMedicamentIds(Collection<Long> medicamentIds) {
        this.medicamentIds = medicamentIds;
        return this;
    }

    public Long getPraticienId() {
        return praticienId;
    }

    public ReportBody setPraticienId(Long praticienId) {
        this.praticienId = praticienId;
        return this;
    }

    public String getNote() {
        return note;
    }

    public ReportBody setNote(String note) {
        this.note = note;
        return this;
    }

    public int getSampleNumber() {
        return sampleNumber;
    }

    public ReportBody setSampleNumber(int sampleNumber) {
        this.sampleNumber = sampleNumber;
        return this;
    }

    public LocalDate getLocalDate()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(getDate(), formatter);
    }

    public String getLabel() {
        return label;
    }

    public ReportBody setLabel(String label) {
        this.label = label;
        return this;
    }
}

