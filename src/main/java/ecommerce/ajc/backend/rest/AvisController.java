package ecommerce.ajc.backend.rest;

import ecommerce.ajc.backend.model.Avis;
import ecommerce.ajc.backend.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/avis")
public class AvisController {
    @Autowired
    AvisRepository avisRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllAvis(){
        return ResponseEntity.ok().body(avisRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<?> createAvis(@RequestBody Avis avis){
        avisRepository.save(avis);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAvis(@RequestBody Avis avis){
        avisRepository.save(avis);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAvis(@PathVariable long id){
        avisRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAvis(@PathVariable long id){
        return ResponseEntity.ok().body(avisRepository.findById(id));
    }
}