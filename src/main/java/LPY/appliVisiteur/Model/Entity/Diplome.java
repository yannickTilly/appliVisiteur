package LPY.appliVisiteur.Model.Entity;

import javax.persistence.*;

@Entity
public class Diplome {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
