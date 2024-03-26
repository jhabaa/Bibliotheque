package com.bibliotheque.biblio;

/**************************************************************************
* Source File	:  Ressource.java
* Author                   :  ABA'A  
* Project name         :  Non enregistr�* Created                 :  02/06/2021
* Modified   	:  02/06/2021
* Description	:  Definition of the class Ressource
**************************************************************************/
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import java.util.Collection;

import javax.persistence.*;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.GenericGenerator;


import lombok.*;
import lombok.NoArgsConstructor;

@Table(name="Ressource")
@Data
@Component
@NoArgsConstructor
@Entity
public class Ressource{
    public String zone;
   
    @Size(max = 15, message = "trop de caractères")
    private String titre;
    private Integer caution;
    private Integer nbrepages;
    private String etat;
    private String rubrique;
    private Integer nbredexemplaires;
    private String resume;
    private String auteur;
    private String image;

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String idres;

    //Attributes Association
    @OneToMany
    @JoinTable(name="posseder", joinColumns = 
    @JoinColumn(name="code_barre") ,
    inverseJoinColumns=
        @JoinColumn(name="IDRES")
                )
	private Collection<Exemplaire> exemplaires;
	 
}
