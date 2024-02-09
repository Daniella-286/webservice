package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    // Ajoutez des méthodes spécifiques si nécessaire
    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email AND u.mdp = :mdp")
    Utilisateur findByEmailAndMdp(@Param("email") String email, @Param("mdp") String mdp);
}
