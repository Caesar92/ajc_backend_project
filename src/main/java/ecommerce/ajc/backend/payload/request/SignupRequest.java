package ecommerce.ajc.backend.payload.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class SignupRequest {

    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    @NotBlank
    private String adresse;

    @NotBlank
    private String ville;

    @NotBlank
    private String prenom;

    @NotBlank
    private String nom;

    @NotBlank
    private String dateDeNaissance;

    @NotBlank
    private String pays;

    @NotBlank
    private String codePostal;

    public SignupRequest() {}

    public SignupRequest(String email, String password, String adresse, String ville, String prenom, String nom, String dateDeNaissance, String pays, String codePostal) {
        this.email = email;
        this.password = password;
        this.adresse = adresse;
        this.ville = ville;
        this.prenom = prenom;
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.pays = pays;
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return this.email;
    }
}