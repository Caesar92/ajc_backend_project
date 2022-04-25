package ecommerce.ajc.backend.service;

import ecommerce.ajc.backend.model.*;
import ecommerce.ajc.backend.payload.request.SignupRequest;
import ecommerce.ajc.backend.repository.RoleRepository;
import ecommerce.ajc.backend.repository.UserRepository;
import ecommerce.ajc.backend.repository.VetementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VetementRepository vetementRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StockService stockService;

    public boolean checkIfUserExist(String email){
        return userRepository.existsByEmail(email);
    }

    @Transactional
    public void signup(SignupRequest signupRequest) {

        Role r  = roleRepository.findByNameRole(ERole.ROLE_USER);
        List<Role> roleList = Arrays.asList(r);
        List<Vetement> vetementList = new ArrayList<>();

        signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));


        User u = new User(
                signupRequest.getEmail(), signupRequest.getPassword(),
                signupRequest.getAdresse(), signupRequest.getCodePostal(), signupRequest.getVille(), signupRequest.getPays(),
                signupRequest.getPrenom(), signupRequest.getNom(), signupRequest.getDateDeNaissance(),
                roleList,vetementList
        );

        userRepository.save(u);

    }
    public void addVetement(long userId, long vetementId){
        User user = userRepository.findById(userId).get();
        user.getListVetement().add(vetementRepository.findById(vetementId).get());
        userRepository.save(user);
    }
    public void deleteVetement(long userId, long vetementId){
        User user = userRepository.findById(userId).get();
        Vetement vetement = vetementRepository.findById(vetementId).get();
        user.getListVetement().remove(vetement);
        for (Stock s : vetement.getStockList()
             ) {
            stockService.increaseStock(s.getId());
        }
        userRepository.save(user);
    }
    public void clearVetement(long userId){
        User user = userRepository.findById(userId).get();
        for (Vetement vetement : user.getListVetement()
        ) {
            for (Stock s : vetement.getStockList()
                 ) {
                stockService.increaseStock(s.getId());
            };
        }
        user.getListVetement().clear();
        userRepository.save(user);
    }
    public void paidVetement(long userId){
        User user = userRepository.findById(userId).get();
        user.getListVetement().clear();
        userRepository.save(user);
    }

}