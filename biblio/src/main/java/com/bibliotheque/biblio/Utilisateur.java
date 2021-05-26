package com.bibliotheque.biblio;

import java.io.Serializable;

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
import lombok.NoArgsConstructor;

@Table(name="Utilisateur")
@Entity
@Component
@Data
@NoArgsConstructor
public class Utilisateur implements Serializable{
    @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicates that the persistence provider must assign primary keys for the entity using a database identity column.
  // @Column(name = "IdUtilisateur")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idutilisateur;
    
    private String nom;
    private String prenom;
    private String password;
    private String email;
    private Integer telephone;
    
}
