package com.bibliotheque.biblio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import lombok.Data;

@Table(name="utilisateur")
@Data
@Entity
@Component
public class Utilisateur {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicates that the persistence provider must assign primary keys for the entity using a database identity column.
   // @Column(name = "uid")
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private String nom;
    private String uid;
    private String password;
    private String email;

    public String getNom()
    {
        return nom;
    }
    public void setNom(String nouveauNom)
    {
        this.nom = nouveauNom;
    }
    public String getUid()
    {
        return uid;
    }
    public void setUid(String id)
    {
        this.uid = id;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String mail){
        this.email = mail;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getRole() {
        return null;
    }
}
