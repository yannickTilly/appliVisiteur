package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView(UserView.user.class)
    private long id;

    @JsonView(UserView.user.class)
    private String nom;

    @JsonView(UserView.user.class)
    private String login;

    @OneToMany(mappedBy="user")
    private Collection<RapportVisite> rapportVisites ;

    @OneToMany(mappedBy = "user")
    @JsonView(UserView.user.class)
    private Collection<PeriodeTravaillee> periodeTravaillees;

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

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

    public Collection<RapportVisite> getRapportVisites() {
        return rapportVisites;
    }

    public User setRapportVisites(Collection<RapportVisite> rapportVisites) {
        this.rapportVisites = rapportVisites;
        return this;
    }

    public Collection<PeriodeTravaillee> getPeriodeTravaillees() {
        return periodeTravaillees;
    }

    public User setPeriodeTravaillees(Collection<PeriodeTravaillee> periodeTravaillees) {
        this.periodeTravaillees = periodeTravaillees;
        return this;
    }
}
