package ecommerce.ajc.backend.service;

import ecommerce.ajc.backend.model.Avis;
import ecommerce.ajc.backend.model.Vetement;
import ecommerce.ajc.backend.repository.VetementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VetementService {

    @Autowired
    VetementRepository vetementRepository;

    public void addAvisOnVetement(Long id, Avis avis){
        Vetement vetement =  vetementRepository.findById(id).get();
        vetement.getAvisList().add(avis);
        vetementRepository.save(vetement);
    }

}
