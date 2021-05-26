package com.bibliotheque.biblio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import org.springframework.stereotype.Component;
import org.hibernate.annotations.GenericGenerator;

import lombok.*;
import lombok.NoArgsConstructor;

@Table(name="Ressource")
@SecondaryTable(name="emplacement")
@Data
@Component
@NoArgsConstructor
@Entity
public class Ressource{
    public String zone;
    private Integer code_barre;
    private String titre;
    private Integer caution;
    private Integer nbrepages;
    private String etat;
    private String rubrique;
    private Integer nbredexemplaires;
    private String resume;

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String idres; 
}
