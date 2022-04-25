package ecommerce.ajc.backend.repository;


import ecommerce.ajc.backend.model.Vetement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VetementRepository extends CrudRepository <Vetement,Long> {
    @Query(value =
            "SELECT DISTINCT v " +
                    "FROM Vetement v " +
                    "JOIN v.stockList s " +
                    "WHERE " +
                    "s.taille IN (:taille)" +
                    "AND v.price BETWEEN :min AND :max " +
                    "AND v.sexe IN (:sexe)")
    List<Vetement> getFilter(
            @Param("taille") String[] taille,
            @Param("min") int min,
            @Param("max") int max,
            @Param("sexe") String[] sexe
    );


}
