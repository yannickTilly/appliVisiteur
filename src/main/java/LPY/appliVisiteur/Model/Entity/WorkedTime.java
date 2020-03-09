package LPY.appliVisiteur.Model.Entity;

import LPY.appliVisiteur.Model.View.Visiteur.WorkedTimeView;
import LPY.appliVisiteur.Model.View.Visiteur.ReportView;
import LPY.appliVisiteur.Model.View.Visiteur.UserView;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WorkSchedules")
public class WorkedTime {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true)
    @JsonView({ReportView.Report.class, ReportView.Report.class})
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonView({WorkedTimeView.PeriodeTravaille.class, UserView.User.class})
    private Department department;

    @ManyToOne
    @JoinColumn(name = "region_id")
    @JsonView({WorkedTimeView.PeriodeTravaille.class, UserView.User.class})
    private Region region;

    @Column(name = "date_start")
    @JsonView({WorkedTimeView.PeriodeTravaille.class, UserView.User.class})
    private Date dateStart;

    @Column(name = "date_end")
    @JsonView({WorkedTimeView.PeriodeTravaille.class, UserView.User.class})
    private Date dateEnd;



    public long getId() {
        return id;
    }

    public WorkedTime setId(long id) {
        this.id = id;
        return this;
    }

    public User     getUser() {
        return user;
    }

    public WorkedTime setUser(User user) {
        this.user = user;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public WorkedTime setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public WorkedTime setRegion(Region region) {
        this.region = region;
        return this;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public WorkedTime setDateStart(Date dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public WorkedTime setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }
}

