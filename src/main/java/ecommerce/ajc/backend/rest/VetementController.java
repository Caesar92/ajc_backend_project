package ecommerce.ajc.backend.rest;

import ecommerce.ajc.backend.model.Avis;
import ecommerce.ajc.backend.model.Vetement;
import ecommerce.ajc.backend.repository.VetementRepository;
import ecommerce.ajc.backend.service.VetementService;
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

    @Autowired
    VetementService vetementService;

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

    @PutMapping("/addAvis/{id}")
    public ResponseEntity <?> addAvis(@PathVariable long id, @RequestBody Avis avis){
        vetementService.addAvisOnVetement(id, avis);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/filtre")
    public ResponseEntity <?> getVetementByTaille(
            @RequestParam(required = false) String[] taille,
            @RequestParam(value = "min" , required = false) Integer min,
            @RequestParam(required = false) Integer max,
            @RequestParam(required = false) String[] sexe

    ){
        if(taille == null){
            taille = new String[]{"S", "M", "L"};
        }
        if(min == null){
            min = 0;
        }
        if(max == null){
            max = 100000000;
        }

        if(sexe == null){
            sexe = new String[]{"Homme", "Femme", "Unisexe"};
        }
        return ResponseEntity.ok().body(vetementRepository.getFilter(taille, min, max, sexe));
    }

}
