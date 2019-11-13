package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({UserView.User.class, ReportView.DelegueRapportVisite.class})
    private long id;

    @JsonView({UserView.User.class, ReportView.DelegueRapportVisite.class})
    @Column(name = "first_name")
    private String prenom;

    @JsonView({UserView.User.class, ReportView.DelegueRapportVisite.class})
    @Column(name = "last_name")
    private String nom;

    @JsonView({UserView.User.class, ReportView.DelegueRapportVisite.class})
    @Column(name = "login", unique = true)
    private String login;


    @Column(name = "password")
    private String password;

    @JsonView(UserView.User.class)
    @Column(name = "cp")
    private String codePostal;

    @JsonView(UserView.User.class)
    @Column(name = "city")
    private String ville;

    @JsonView(UserView.User.class)
    @Column(name = "hiring_date")
    private String hiringDate;

    @JsonView(UserView.User.class)
    @Column(name = "matricule")
    private String matricule;

    @OneToMany(mappedBy="user")
    private Collection<Report> reports;

    @OneToMany(mappedBy = "user")
    @JsonView(UserView.User.class)
    private Collection<WorkedTime> workedTimes;

    @ManyToOne()
    private Region region;


    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public User setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public User setCodePostal(String codePostal) {
        this.codePostal = codePostal;
        return this;
    }

    public String getVille() {
        return ville;
    }

    public User setVille(String ville) {
        this.ville = ville;
        return this;
    }

    public Collection<Report> getReports() {
        return reports;
    }

    public User setReports(Collection<Report> reports) {
        this.reports = reports;
        return this;
    }

    public Collection<WorkedTime> getWorkedTimes() {
        return workedTimes;
    }

    public User setWorkedTimes(Collection<WorkedTime> workedTimes) {
        this.workedTimes = workedTimes;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public User setRegion(Region region) {
        this.region = region;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public User setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public User setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
        return this;
    }

    public String getMatricule() {
        return matricule;
    }

    public User setMatricule(String matricule) {
        this.matricule = matricule;
        return this;
    }
}
