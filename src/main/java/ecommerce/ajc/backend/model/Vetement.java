package ecommerce.ajc.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    String marque;
    String couleur;
    String intitulé;
    String photo;
    int price;
    boolean sexe;
    @OneToMany
    List <Avis> avisList;
    @ManyToOne
    Categorie categorie;
    @ManyToMany
    List<Stock> stockList;

}
