package fr.eservices.drive.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StatusHistory {


    @Id
    @GeneratedValue
    private Long id;
    private Status status;
    @Temporal(TemporalType.DATE)
    private Date statusDate;

    public StatusHistory() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
}
