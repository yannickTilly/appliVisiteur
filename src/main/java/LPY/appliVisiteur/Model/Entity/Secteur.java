package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.PeriodeTravailleeView;
import LPY.appliVisiteur.Model.View.Visiteur.RegionView;
import LPY.appliVisiteur.Model.View.Visiteur.SecteurView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "Sectors")
public class Secteur {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({UserView.User.class, SecteurView.Secteur.class})
    private long id;

    @Column(name = "code", length = 10)
    @JsonView({UserView.User.class, SecteurView.Secteur.class})
    private String code;

    @Column(name = "name", length = 30)
    @JsonView({UserView.User.class, SecteurView.Secteur.class})
    private String name;

    public long getId() {
        return id;
    }

    public Secteur setId(long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Secteur setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Secteur setName(String name) {
        this.name = name;
        return this;
    }
}
