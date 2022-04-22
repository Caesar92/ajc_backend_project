package ecommerce.ajc.backend.rest;

import ecommerce.ajc.backend.model.Role;
import ecommerce.ajc.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class RoleController {
        @Autowired
        RoleRepository roleRepository;

        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity <?> getAllRoles(){
            return ResponseEntity.ok().body(roleRepository.findAll());
        }
        @PostMapping
        public ResponseEntity <?> createRole(@RequestBody Role role){
            roleRepository.save(role);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        @PutMapping("/{id}")
        public ResponseEntity<?> updateRole(@RequestBody Role role){
            roleRepository.save(role);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteRole(@PathVariable long id){
            roleRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        @GetMapping("/{id}")
        public ResponseEntity<?> getRole(@PathVariable long id){
            return ResponseEntity.ok().body(roleRepository.findById(id));
        }


}
