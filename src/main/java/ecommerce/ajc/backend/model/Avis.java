package ecommerce.ajc.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Avis {
    @Id
    @GeneratedValue
    long id;
    String nomUser;
    String commentaire;
    int note;

}
