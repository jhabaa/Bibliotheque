package com.bibliotheque.biblio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String nom;

    public String getUsername()
    {
        return nom;
    }
    public void setUsername(String nouveauNom)
    {
        this.nom = nouveauNom;
    }
}
