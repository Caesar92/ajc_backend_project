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
public class Panier {
    @Id
    @GeneratedValue
    long id;
    @OneToOne
    UserInfo userInfo;
    @ManyToMany
    List <Vetement> vetementList;
}
