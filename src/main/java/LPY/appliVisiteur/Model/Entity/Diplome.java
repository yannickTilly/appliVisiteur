package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.DepartementView;
import LPY.appliVisiteur.Model.View.Visiteur.DiplomeView;
import LPY.appliVisiteur.Model.View.Visiteur.PraticienView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
public class Diplome {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView({DepartementView.Departement.class, PraticienView.Praticien.class, DiplomeView.Diplome.class})
    private long id;

    @ManyToOne
    private Praticien praticien;

    public long getId() {
        return id;
    }

    public Diplome setId(long id) {
        this.id = id;
        return this;
    }

    public Praticien getPraticien() {
        return praticien;
    }

    public Diplome setPraticien(Praticien praticien) {
        this.praticien = praticien;
        return this;
    }
}
