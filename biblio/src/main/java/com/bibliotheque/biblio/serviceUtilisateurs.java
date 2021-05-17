package com.bibliotheque.biblio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class serviceUtilisateurs implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = userRepository.getUtilisateur(username);
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
       if (utilisateur == null){
           throw new UsernameNotFoundException("Utilisateur non trouvé dans la base");
       }
       else 
       
        return new detailsUtilisateurs(utilisateur);
    }
    
}
