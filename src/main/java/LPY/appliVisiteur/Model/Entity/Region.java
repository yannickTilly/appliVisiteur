package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.WorkedTimeView;
import LPY.appliVisiteur.Model.View.Visiteur.RegionView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Regions")
public class Region {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({WorkedTimeView.PeriodeTravaille.class, UserView.User.class, RegionView.Region.class})
    private long id;

    @Column(name = "code", length = 10)
    @JsonView({WorkedTimeView.PeriodeTravaille.class, UserView.User.class, RegionView.Region.class})
    private String code;

    @Column(name = "name", length = 30)
    @JsonView({WorkedTimeView.PeriodeTravaille.class, UserView.User.class, RegionView.Region.class})
    private String name;

    @OneToMany(mappedBy = "region")
    private Collection<WorkedTime> workedTimes;

    @ManyToOne
    @JsonView(UserView.User.class)
    private Sector sector;

    @OneToMany(mappedBy = "region")
    private Collection<User> delegues;

    @OneToMany(mappedBy = "region")
    private Collection<Report> reports;



    public long getId() {
        return id;
    }

    public Region setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<WorkedTime> getWorkedTimes() {
        return workedTimes;
    }

    public Region setWorkedTimes(Collection<WorkedTime> workedTimes) {
        this.workedTimes = workedTimes;
        return this;
    }

    public Sector getSector() {
        return sector;
    }

    public Region setSector(Sector sector) {
        this.sector = sector;
        return this;
    }

    public Collection<User> getDelegues() {
        return delegues;
    }

    public Region setDelegues(Collection<User> delegues) {
        this.delegues = delegues;
        return this;
    }

    public Collection<Report> getReports() {
        return reports;
    }

    public Region setReports(Collection<Report> reports) {
        this.reports = reports;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Region setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Region setName(String name) {
        this.name = name;
        return this;
    }
}
