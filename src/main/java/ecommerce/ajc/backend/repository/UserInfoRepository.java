package ecommerce.ajc.backend.repository;

import ecommerce.ajc.backend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository <User,Long> {
}
