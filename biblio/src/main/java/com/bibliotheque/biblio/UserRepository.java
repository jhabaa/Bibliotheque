package com.bibliotheque.biblio;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends CrudRepository<Utilisateur, Integer> {

    @Query("SELECT nomUtil FROM Utilisateur nomUtil WHERE nomUtil.nom = :nom")
    public Utilisateur getUtilisateur(@Param("nom") String nom);

    List<Utilisateur> findByNom(@Param("nom") String nom);

}

   

