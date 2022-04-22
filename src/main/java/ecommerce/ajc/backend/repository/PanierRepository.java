package ecommerce.ajc.backend.repository;


import ecommerce.ajc.backend.model.Panier;
import org.springframework.data.repository.CrudRepository;

public interface PanierRepository extends CrudRepository <Panier,Long> {
}
