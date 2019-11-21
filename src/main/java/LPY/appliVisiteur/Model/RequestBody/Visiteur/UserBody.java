package LPY.appliVisiteur.Model.RequestBody.Visiteur;

import java.util.Date;

public class UserBody {
    private String prenom;

    private String nom;

    private Long id;

    private String login;

    private String password;

    private String matricule;

    private String hiringDate;

    private Long regionId;

    private Integer numeroVoie;

    private String typeVoie;

    private String nomVoie;

    private String codePostal;

    private String ville;

    public String getPrenom() {
        return prenom;
    }

    public UserBody setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public UserBody setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserBody setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserBody setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserBody setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMatricule() {
        return matricule;
    }

    public UserBody setMatricule(String matricule) {
        this.matricule = matricule;
        return this;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public UserBody setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
        return this;
    }

    public Long getRegionId() {
        return regionId;
    }

    public UserBody setRegionId(Long regionId) {
        this.regionId = regionId;
        return this;
    }

    public Integer getNumeroVoie() {
        return numeroVoie;
    }

    public UserBody setNumeroVoie(Integer numeroVoie) {
        this.numeroVoie = numeroVoie;
        return this;
    }

    public String getTypeVoie() {
        return typeVoie;
    }

    public UserBody setTypeVoie(String typeVoie) {
        this.typeVoie = typeVoie;
        return this;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public UserBody setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
        return this;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public UserBody setCodePostal(String codePostal) {
        this.codePostal = codePostal;
        return this;
    }

    public String getVille() {
        return ville;
    }

    public UserBody setVille(String ville) {
        this.ville = ville;
        return this;
    }
}
