package ecommerce.ajc.backend.repository;


import ecommerce.ajc.backend.model.ERole;
import ecommerce.ajc.backend.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository <Role,Long> {
    Role findByNameRole(ERole name);
}
