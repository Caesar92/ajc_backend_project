package ecommerce.ajc.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

