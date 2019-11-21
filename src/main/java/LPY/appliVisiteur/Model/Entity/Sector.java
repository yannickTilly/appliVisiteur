package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.SectorView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "Sectors")
public class Sector {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({UserView.User.class, SectorView.Secteur.class})
    private long id;

    @Column(name = "code", length = 10)
    @JsonView({UserView.User.class, SectorView.Secteur.class})
    private String code;

    @Column(name = "name", length = 30)
    @JsonView({UserView.User.class, SectorView.Secteur.class})
    private String name;

    public long getId() {
        return id;
    }

    public Sector setId(long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Sector setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Sector setName(String name) {
        this.name = name;
        return this;
    }
}
