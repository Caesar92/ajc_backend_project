package ecommerce.ajc.backend.repository;


import ecommerce.ajc.backend.model.Vetement;
import org.springframework.data.repository.CrudRepository;

public interface VetementRepository extends CrudRepository <Vetement,Long> {
}
