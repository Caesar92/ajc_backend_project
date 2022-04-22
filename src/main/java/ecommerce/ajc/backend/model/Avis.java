package ecommerce.ajc.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Avis {
    @Id
    @GeneratedValue
    long id;
    String nomUser;
    String commentaire;
    int note;

}
