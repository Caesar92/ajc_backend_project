package ecommerce.ajc.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String email;
    String password;
    @ManyToMany
    List <Role> listRole;

}

