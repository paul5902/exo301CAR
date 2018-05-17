package fr.eservices.drive.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product extends Article{

    public Product() {};
}
