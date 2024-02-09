package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Favoris;

public interface FavorisRepository extends JpaRepository<Favoris, Integer> {

    // Ajoutez des méthodes spécifiques si nécessaire
}
