package LPY.appliVisiteur.Model.RequestBody.Visiteur;

public class VisiteurBody {
    private Integer numeroVoie;

    private String typeVoie;

    private String nomVoie;

    private String codePostal;

    private String ville;

    public Integer getNumeroVoie() {
        return numeroVoie;
    }

    public VisiteurBody setNumeroVoie(int numeroVoie) {
        this.numeroVoie = numeroVoie;
        return this;
    }

    public String getTypeVoie() {
        return typeVoie;
    }

    public VisiteurBody setTypeVoie(String typeVoie) {
        this.typeVoie = typeVoie;
        return this;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public VisiteurBody setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
        return this;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public VisiteurBody setCodePostal(String codePostal) {
        this.codePostal = codePostal;
        return this;
    }

    public String getVille() {
        return ville;
    }

    public VisiteurBody setVille(String ville) {
        this.ville = ville;
        return this;
    }
}
