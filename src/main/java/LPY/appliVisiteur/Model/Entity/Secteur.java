package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.SecteurView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Secteur {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView({UserView.User.class, SecteurView.Secteur.class})
    private long id;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
