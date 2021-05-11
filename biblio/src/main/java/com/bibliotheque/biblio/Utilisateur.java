package com.bibliotheque.biblio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Utilisateur {
    @Id
    @GeneratedValue(generator="system-uuid")
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    
    private String nom;
    private String idUtilisateur;

    public String getName()
    {
        return nom;
    }
    public void setName(String nouveauNom)
    {
        this.nom = nouveauNom;
    }
    public String getIdutilisateur()
    {
        return idUtilisateur;
    }
    public void setIdutilisateur(String id)
    {
        this.idUtilisateur = id;
    }
}
