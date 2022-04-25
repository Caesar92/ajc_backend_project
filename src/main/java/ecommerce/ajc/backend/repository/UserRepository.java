package ecommerce.ajc.backend.repository;

import ecommerce.ajc.backend.model.User;
import ecommerce.ajc.backend.model.Vetement;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;
/*import org.springframework.data.repository.CrudRepository;*/

public interface UserRepository extends JpaRepository <User,Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
