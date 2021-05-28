package com.bibliotheque.biblio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ressourceRepository extends CrudRepository<Ressource, String> {
    
}
