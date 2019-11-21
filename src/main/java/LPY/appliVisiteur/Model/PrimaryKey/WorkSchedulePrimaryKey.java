package LPY.appliVisiteur.Model.PrimaryKey;

import LPY.appliVisiteur.Model.Entity.User;

import java.io.Serializable;
import java.util.Date;

public class WorkSchedulePrimaryKey implements Serializable {
    private User user;
    private Date dateStart;
    private Date dateEnd;

    public WorkSchedulePrimaryKey(User user, Date dateStart, Date dateEnd)
    {
        this.user = user;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public User getUser() {
        return user;
    }

    public WorkSchedulePrimaryKey setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public WorkSchedulePrimaryKey setDateStart(Date dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public WorkSchedulePrimaryKey setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }
}
