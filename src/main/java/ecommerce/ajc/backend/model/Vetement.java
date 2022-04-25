package ecommerce.ajc.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Vetement {
    @Id
    @GeneratedValue
    long id;
    String intitulé;
    String marque;
    String couleur;

    String photo;
    int price;
    String sexe;


    @OneToMany
    List <Avis> avisList;
    @ManyToOne
    Categorie categorie;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Stock> stockList;

}
