package com.bibliotheque.biblio;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Table(name="Utilisateur")
@Entity
@Component
@Data
@NoArgsConstructor
@Scope("session")
public class Utilisateur implements Serializable{
    @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicates that the persistence provider must assign primary keys for the entity using a database identity column.
  // @Column(name = "IdUtilisateur")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idutilisateur;

    @Size(min = 3, max = 5, message = "Try again")
    @NotNull
    private String nom;

    private String prenom;

    @javax.validation.constraints.NotEmpty(message = "enter password")
    private String password;

    private String email;
    private Integer telephone;

    //Attributes Association
    @OneToMany
    @JoinTable(name="Emprunter", joinColumns = 
    @JoinColumn(name = "code_barre"),
    inverseJoinColumns=
        @JoinColumn(name="IDUTILISATEUR")
                )
	private Collection<Exemplaire> exemplaires;


    
}
