package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.PrimaryKey.WorkSchedulePrimaryKey;
import LPY.appliVisiteur.Model.View.Visiteur.PeriodeTravailleeView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@IdClass(WorkSchedulePrimaryKey.class)
@Table(name = "WorkSchedules")
public class PeriodeTravaillee {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonView({PeriodeTravailleeView.PeriodeTravaille.class, UserView.User.class})
    private Departement departement;

    @ManyToOne
    @JoinColumn(name = "region_id")
    @JsonView({PeriodeTravailleeView.PeriodeTravaille.class, UserView.User.class})
    private Region region;

    @Id
    @Column(name = "date_start")
    @JsonView({PeriodeTravailleeView.PeriodeTravaille.class, UserView.User.class})
    private Date dateStart;

    @Id
    @Column(name = "date_end")
    @JsonView({PeriodeTravailleeView.PeriodeTravaille.class, UserView.User.class})
    private Date dateEnd;

    public User getUser() {
        return user;
    }

    public PeriodeTravaillee setUser(User user) {
        this.user = user;
        return this;
    }

    public Departement getDepartement() {
        return departement;
    }

    public PeriodeTravaillee setDepartement(Departement departement) {
        this.departement = departement;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public PeriodeTravaillee setRegion(Region region) {
        this.region = region;
        return this;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public PeriodeTravaillee setDateStart(Date dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public PeriodeTravaillee setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }
}

