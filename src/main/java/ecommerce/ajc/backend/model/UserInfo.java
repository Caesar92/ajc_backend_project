package ecommerce.ajc.backend.model;

import javax.persistence.*;


@Entity
public class UserInfo {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
long id;

        String adresse;
        String ville;
        String prenom;
        String nom;
        String dateDeNaissance;
        String sexe;
        String pays;
        int codePostal;
        @OneToOne
        User user;
    }

