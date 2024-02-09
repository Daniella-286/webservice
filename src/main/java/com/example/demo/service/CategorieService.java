package com.example.demo.service;

import com.example.demo.model.Categorie;
import com.example.demo.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Optional<Categorie> getCategorieById(Long id) {
        return categorieRepository.findById(id);
    }

    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public void updateCategorie(Long id, Categorie updatedCategorie) {
        Optional<Categorie> existingCategorie = categorieRepository.findById(id);
        existingCategorie.ifPresent(c -> {
            c.setCategorieName(updatedCategorie.getCategorieName());
            categorieRepository.save(c);
        });
    }

    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}
