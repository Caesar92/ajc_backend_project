package ecommerce.ajc.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Categorie {
    @Id
    @GeneratedValue
    long id;
    String name;

}
