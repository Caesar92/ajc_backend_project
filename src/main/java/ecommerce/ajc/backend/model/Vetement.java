package ecommerce.ajc.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vetement {
    @Id
    @GeneratedValue
    long id;

    String marque;
    String taille;
    String couleur;
    String intitulé;
    String photo;
    int price;
    int quantite;
    boolean sexe;
    @OneToMany
    List <Avis> avisList;
    @ManyToOne
    Categorie categorie;

}
