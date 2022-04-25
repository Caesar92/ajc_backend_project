package ecommerce.ajc.backend.security.services;

import ecommerce.ajc.backend.model.User;
import ecommerce.ajc.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("email " + email + " not found"));

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user
                .getListRole()
                .forEach(r -> grantedAuthorities.add(new SimpleGrantedAuthority(r.getNameRole().name())));

        return UserDetailsImpl.build(user);
    }
}
