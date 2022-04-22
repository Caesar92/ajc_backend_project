package ecommerce.ajc.backend.repository;

import ecommerce.ajc.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.repository.CrudRepository;*/

public interface UserRepository extends JpaRepository <User,Long> {
}
