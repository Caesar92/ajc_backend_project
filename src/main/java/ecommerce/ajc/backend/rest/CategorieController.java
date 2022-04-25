package ecommerce.ajc.backend.rest;

import ecommerce.ajc.backend.model.Categorie;
import ecommerce.ajc.backend.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    @Autowired
    CategorieRepository categorieRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok().body(categorieRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Categorie categorie){
        categorieRepository.save(categorie);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategorie(@RequestBody Categorie categorie){
        categorieRepository.save(categorie);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategorie(@PathVariable long id){
        categorieRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategorie(@PathVariable long id){
        return ResponseEntity.ok().body(categorieRepository.findById(id));
    }
}
