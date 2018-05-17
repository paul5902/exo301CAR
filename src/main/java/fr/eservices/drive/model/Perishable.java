package fr.eservices.drive.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Perishable extends Article{

    @Temporal(TemporalType.DATE)
    private Date bestBefore;

    private String lot;


    public Perishable() {
    }
}
