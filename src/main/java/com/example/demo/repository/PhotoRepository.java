package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    // Ajoutez des méthodes spécifiques si nécessaire

    @Query("SELECT p FROM Photo p WHERE p.id_annonce = :id")
    List<Photo> findPhotoAnnonce(@Param("id") int id);
}
