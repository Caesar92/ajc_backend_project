package ecommerce.ajc.backend.service;

import ecommerce.ajc.backend.model.ERole;
import ecommerce.ajc.backend.model.Role;
import ecommerce.ajc.backend.model.User;
import ecommerce.ajc.backend.payload.request.SignupRequest;
import ecommerce.ajc.backend.repository.RoleRepository;
import ecommerce.ajc.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean checkIfUserExist(String email){
        return userRepository.existsByEmail(email);
    }

    @Transactional
    public void signup(SignupRequest signupRequest) {

        Role r  = roleRepository.findByNameRole(ERole.ROLE_USER);
        List<Role> roleList = Arrays.asList(r);

        signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));


        User u = new User(
                signupRequest.getEmail(), signupRequest.getPassword(),
                signupRequest.getAdresse(), signupRequest.getCodePostal(), signupRequest.getVille(), signupRequest.getPays(),
                signupRequest.getPrenom(), signupRequest.getNom(), signupRequest.getDateDeNaissance(),
                roleList
        );

        userRepository.save(u);

    }
}