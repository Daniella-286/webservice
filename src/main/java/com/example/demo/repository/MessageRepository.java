package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Messagerie;

public interface MessageRepository extends JpaRepository<Messagerie, Integer> {
    @Query("SELECT m FROM Messagerie m WHERE m.emetteur = :id OR m.recepteur = :id")
    List<Messagerie> findMessageUser(@Param("id") int id);
    // Ajoutez des méthodes spécifiques si nécessaire
}
