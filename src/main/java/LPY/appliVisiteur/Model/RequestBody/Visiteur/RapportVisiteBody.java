package LPY.appliVisiteur.Model.RequestBody.Visiteur;

import java.util.Collection;

public class RapportVisiteBody {
    private Collection<Long> MedicamentId;
    private Long praticienId;
    private String note;

    public Collection<Long> getMedicamentId() {
        return MedicamentId;
    }

    public RapportVisiteBody setMedicamentId(Collection<Long> medicamentId) {
        MedicamentId = medicamentId;
        return this;
    }

    public Long getPraticienId() {
        return praticienId;
    }

    public RapportVisiteBody setPraticienId(Long praticienId) {
        this.praticienId = praticienId;
        return this;
    }

    public String getNote() {
        return note;
    }

    public RapportVisiteBody setNote(String note) {
        this.note = note;
        return this;
    }
}
