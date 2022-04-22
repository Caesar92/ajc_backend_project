package ecommerce.ajc.backend.repository;

import ecommerce.ajc.backend.model.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository <Stock,Long> {
}
