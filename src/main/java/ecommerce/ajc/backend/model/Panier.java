package ecommerce.ajc.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Panier {
    @Id
    @GeneratedValue
    long id;
    @OneToOne
    UserInfo userInfo;
    @ManyToMany
    List <Vetement> vetementList;
}
