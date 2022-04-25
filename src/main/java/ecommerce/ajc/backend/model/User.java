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
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String email;
    String password;

    String adresse;
    String ville;
    String prenom;
    String nom;
    String dateDeNaissance;
    String pays;
    String codePostal;

    @ManyToMany(fetch = FetchType.EAGER)
    List <Role> listRole;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Vetement> vetementList;

    public User(String email, String password, String adresse, String codePostal, String ville,  String pays, String prenom, String nom, String dateDeNaissance, List<Role> listRole) {
        this.email = email;
        this.password = password;
        this.adresse = adresse;
        this.ville = ville;
        this.prenom = prenom;
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.pays = pays;
        this.codePostal = codePostal;
        this.listRole = listRole;
    }
}

