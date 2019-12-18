package LPY.appliVisiteur.Model.RequestBody.Visiteur;

import java.util.Collection;

public class ReportBody {
    private Collection<Long> medicamentIds;
    private Long praticienId;
    private String note;

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
}
