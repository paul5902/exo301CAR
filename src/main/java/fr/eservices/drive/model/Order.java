package fr.eservices.drive.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date createdOn;
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    private Double amount;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    List<Article> articles;

    private Status currentStatus;

    @OneToMany
    private List<StatusHistory> history;

    public Order(){};


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

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }
}
