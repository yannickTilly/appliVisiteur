package LPY.appliVisiteur.Model.RequestBody.Visiteur;

public class PresentationMedicamentBody {
    private Long IdMedicament;
    private Long IdRapportVisite;

    public Long getIdMedicament() {
        return IdMedicament;
    }

    public PresentationMedicamentBody setIdMedicament(Long idMedicament) {
        IdMedicament = idMedicament;
        return this;
    }

    public Long getIdRapportVisite() {
        return IdRapportVisite;
    }

    public PresentationMedicamentBody setIdRapportVisite(Long idRapportVisite) {
        IdRapportVisite = idRapportVisite;
        return this;
    }
}
