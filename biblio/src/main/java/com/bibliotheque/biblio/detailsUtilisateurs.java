package com.bibliotheque.biblio;

import java.util.Arrays;
import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
public class detailsUtilisateurs implements UserDetails {
 
    private Utilisateur utilisateur;
     
    public detailsUtilisateurs(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(utilisateur.getRole());
        return Arrays.asList(authority);
    }
 
    @Override
    public String getPassword() {
        return utilisateur.getPassword();
    }
 
    
    public String getEmail() {
        return utilisateur.getEmail();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        utilisateur.getNom();
        return null;
    }
 
}