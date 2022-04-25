package ecommerce.ajc.backend.rest;

import ecommerce.ajc.backend.model.Vetement;
import ecommerce.ajc.backend.repository.VetementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/api/vetements")
public class VetementController {
    @Autowired
    VetementRepository vetementRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <?> getALLVetements(){
        return ResponseEntity.ok().body(vetementRepository.findAll());
    }
    @PostMapping
    public ResponseEntity <?> creatVetement(@RequestBody Vetement vetement){
        vetementRepository.save(vetement);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity <?> updateVetement(@RequestBody Vetement vetement){
        vetementRepository.save(vetement);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <?> deleteVetement(@PathVariable long id){
        vetementRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity <?> getVetement(@PathVariable long id){
        return ResponseEntity.ok().body(vetementRepository.findById(id));
    }


}