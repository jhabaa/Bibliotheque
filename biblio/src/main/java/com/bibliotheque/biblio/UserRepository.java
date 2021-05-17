package com.bibliotheque.biblio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends CrudRepository<Utilisateur, String> {

    @Query("SELECT nomUtil FROM Utilisateur nomUtil WHERE nomUtil.nom = :nom")
    public Utilisateur getUtilisateur(@Param("nom") String nom);

}

   

