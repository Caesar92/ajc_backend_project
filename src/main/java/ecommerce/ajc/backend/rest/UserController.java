package ecommerce.ajc.backend.rest;

import ecommerce.ajc.backend.model.User;
import ecommerce.ajc.backend.repository.UserRepository;
import ecommerce.ajc.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity <?> getAllUsers(){
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <?> getUser(@PathVariable long id){
        return ResponseEntity.ok().body(userRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity <?> createUser(@RequestBody User user){
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity <?> upDateUser(@RequestBody User user){
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <?> deleteUser(@PathVariable long id){
        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @PostMapping("/panier")
    public ResponseEntity<?> addVtementToPanier(@RequestParam long userId,  @RequestParam long vetementId){
        userService.addVetement(userId, vetementId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/panier")
    public ResponseEntity<?> deleteVtementToPanier(@RequestParam long userId,  @RequestParam long vetementId){
        userService.deleteVetement(userId, vetementId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @PutMapping("/panier")
    public ResponseEntity<?> clearAllinPanier(@RequestParam long userId){
        userService.clearVetement(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @PutMapping("/transaction")
    public ResponseEntity<?> paidVetement(@RequestParam long userId){
        userService.paidVetement(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
