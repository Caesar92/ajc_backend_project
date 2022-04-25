package ecommerce.ajc.backend.rest;

import ecommerce.ajc.backend.payload.request.LoginRequest;
import ecommerce.ajc.backend.payload.request.SignupRequest;
import ecommerce.ajc.backend.payload.response.JwtResponse;
import ecommerce.ajc.backend.payload.response.MessageResponse;
import ecommerce.ajc.backend.repository.RoleRepository;
import ecommerce.ajc.backend.repository.UserRepository;
import ecommerce.ajc.backend.security.jwt.JwtUtils;
import ecommerce.ajc.backend.security.services.UserDetailsImpl;
import ecommerce.ajc.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignupRequest signupRequest){

        System.out.println(signupRequest);
        boolean userAlreadyExist = userService.checkIfUserExist(signupRequest.getEmail());

        if(userAlreadyExist){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new MessageResponse("User already exist"));
        }

        else{
            userService.signup(signupRequest);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new MessageResponse("User : " + signupRequest.getEmail() + " registered successful"));
        }

    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticate(@Valid @RequestBody LoginRequest loginRequest){



        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getPassword(), roles));

    }
}