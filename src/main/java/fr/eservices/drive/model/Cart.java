package fr.eservices.drive.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Cart {


    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date createdOn;

    @OneToMany
    private List<Article> articles;

    @ManyToOne
    private Customer customer;

    public Cart() {};


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
