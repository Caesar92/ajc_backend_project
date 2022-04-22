package ecommerce.ajc.backend.rest;

import ecommerce.ajc.backend.model.User;
import ecommerce.ajc.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <?> getAllUsers(){
        return ResponseEntity.ok().body(userRepository.findAll());
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
    @GetMapping("/{id}")
    public ResponseEntity <?> getUser(@PathVariable long id){
        return ResponseEntity.ok().body(userRepository.findById(id));
    }
}
